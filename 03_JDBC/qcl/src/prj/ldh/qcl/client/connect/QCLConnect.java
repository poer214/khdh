package prj.ldh.qcl.client.connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import prj.ldh.qcl.client.view.QCLView;
import prj.ldh.qcl.common.dto.Data;

public class QCLConnect implements Runnable {
	private QCLView view;
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private String serverIp;
	private int serverPort;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public QCLConnect() {}
    public QCLConnect(QCLView view) {
    	this.view = view;
    	serverIp = "localhost";
    	serverPort = 9000;
    }
    
    // 서버와 연결하는 메서드
    public void connectToServer(Data loginData) {
    	try {
			socket = new Socket(serverIp, serverPort);
	    	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);
	        System.out.println("서버로 로그인데이터 전송");
			out.println(objectMapper.writeValueAsString(loginData));
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("수신 대기중");
						Data receivedMessage = objectMapper.readValue(in.readLine(), Data.class);
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						view.loginForm.setStateLabel("에러1");
						e.printStackTrace();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						view.loginForm.setStateLabel("에러2");
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						view.loginForm.setStateLabel("에러3");
						e.printStackTrace();
					}
				}
			}).start();
		} catch (UnknownHostException e1) {
			view.loginForm.setStateLabel("알 수 없는 에러");
			e1.printStackTrace();
		} catch (IOException e1) {
			view.loginForm.setStateLabel("서버와 접속할 수 없습니다.");
			e1.printStackTrace();
		}
    }

    // 로그인 정보를 서버로 전송하는 메서드
    public void sendLoginInfo(String username, String password) {
        // JSON 데이터 생성 및 전송 로직 구현
    }

    // 서버로부터 응답을 수신하는 메서드
    public String receiveResponse() {
        // 서버로부터 응답 수신 로직 구현
    	return null;
    }

    // 서버와 연결을 종료하는 메서드
    public void disconnect() throws IOException{
    	if (socket != null) socket.close();
        if (in != null) in.close();
        if (out != null) out.close();
    }

	@Override
	public void run() {
		while (true) {
			try {
				Data receivedMessage = objectMapper.readValue(in.readLine(), Data.class);
				System.out.println("Received message from " + receivedMessage.getType() + ": " + receivedMessage.getContent());
			} catch (JsonMappingException e) {
				System.out.println("JsonMappingException");
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				System.out.println("JsonProcessingException");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
			}
		}
	}
}