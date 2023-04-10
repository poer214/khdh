package gb.client.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import gb.common.dto.LoginDTO;
import gb.common.dto.DTO;

public class GBClientConnecter {
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	ObjectMapper mapper = new ObjectMapper();
	Scanner sc = new Scanner(System.in);
	public GBClientConnecter() {
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("연결 성공");
			System.out.println(socket.getInetAddress());

			// 연결 후 데이터교환을 위한 인풋/아웃풋 스트림 생성
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			String sendData = mapper.writeValueAsString(new LoginDTO("id", "pw"));
			out.writeUTF(sendData);
			String receivedData = in.readUTF();
			System.out.println(receivedData.toString());
			new Thread(()->receiveThread()).start();
			while(true) {
				String msg = sc.nextLine();
				sendData = mapper.writeValueAsString(new DTO("msg",msg));
				out.writeUTF(sendData);
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
		}
	}
	
	private void receiveThread(){
		while (true) {
			try {
				System.out.println("1");
				String receivedData = in.readUTF();
				processJsonData(receivedData);
			} catch (Exception e) {
				System.out.println("데이터 수신중 예외 발생");
				e.printStackTrace();
				break;
			}
		}
	}
	
	private void processJsonData(String receivedData) throws Exception{
		DTO dto = mapper.readValue(receivedData, DTO.class);
		switch(dto.getType()) {
		case "msg":
			System.out.println(dto.getContent());
			break;
		default:
			System.out.println("알 수 없는 신호");
			break;
		}
	}
	
	public static void main(String[] args) {
		new GBClientConnecter();
	}
}
