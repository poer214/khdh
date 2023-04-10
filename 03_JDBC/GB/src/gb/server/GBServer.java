package gb.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import gb.common.dto.DTO;
import gb.common.dto.LoginDTO;
import gb.common.dto.MemberDTO;
import gb.server.dao.GBDAO;

public class GBServer {
	List<Socket> clients = Collections.synchronizedList(new ArrayList<>());
	ObjectMapper mapper = new ObjectMapper();
	GBDAO dao = new GBDAO();
	ServerSocket ss;
	Socket client;
	int port = 9999;
	
	public GBServer() {
		try {
			System.out.println("서버오픈");
			ss = new ServerSocket(port);
			while(true) {
				System.out.println("새 연결을 기다리는중 ...");
				client = ss.accept();
				System.out.println(client.getInetAddress()+"와 연결됨.");
				new Thread(()->receive(client)).start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void receive(Socket client) {
		System.out.println(client.getInetAddress()+"로그인 정보 확인");
		MemberDTO member = null;
		try(DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());) {
			// 연결된 후 처음 받는 데이터 : 로그인데이터로 로그인처리
			// 로그인 정보가 맞다면 성공메시지와 세션아이디 전송 후 계속해서 데이터 수신대기
			// 로그인 정보가 틀렸다면 실패메시지 전송 후 연결 끊기
			String receivedData = in.readUTF();
			LoginDTO loginData = mapper.readValue(receivedData, LoginDTO.class);
			member = dao.login(loginData);
			System.out.println("로그인데이터 받음");
			if(member != null) {
				System.out.println("로그인 성공, 세션아이디 생성");
				String sessionId = UUID.randomUUID().toString();
				DTO response = new DTO("success",sessionId);
				String sendData = mapper.writeValueAsString(response);
				System.out.println("세션아이디 전송");
				out.writeUTF(sendData);
				System.out.println("클라이언트목록에 클라이언트 추가");
				clients.add(client);
				while(true) {
					System.out.println("수신대기");
					receivedData = in.readUTF();
					System.out.println(sessionId + " : " + receivedData.toString());
					System.out.println("받은 데이터 DTO객체화");
					DTO dto = mapper.readValue(receivedData,DTO.class);
					System.out.println("broadcastMsg() 호출");
					broadcastMsg(member.getMemberName(),dto.getContent());
					System.out.println("broadcastMsg() 끝");
				}
			} else {
				System.out.println("로그인 실패");
				DTO response = new DTO("fail","");
				String sendData = mapper.writeValueAsString(response);
				System.out.println("실패메시지 전송");
				out.writeUTF(sendData);
				System.out.println("연결 종료");
				client.close();
			}
		} catch (Exception e) {
			if(member != null)
				System.out.println(member.getMemberId()+"의 접속 끊김");
			else
				System.out.println("수신쓰레드에서 예외 발생");
			e.printStackTrace();
		}
	}
	
	private void broadcastMsg(String name, String msg) {
		try {
			String sendData = mapper.writeValueAsString(new DTO("msg","["+name+"]"+ msg));
			for(Socket s : clients) {
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				out.writeUTF(sendData);
			}
		} catch (Exception e) {
			System.out.println("메시지 전송중 예외 발생");
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		new GBServer();
	}
}