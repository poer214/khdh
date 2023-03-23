package prj.ldh.qcl.server;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;

public class Connecter {
	int port = 9000; // 포트 번호 설정
	int clientId = 0; // 클라이언트 식별자 초기값 설정

	public Connecter() {
		try {
			ServerSocket serverSocket = new ServerSocket(port); // 서버 소켓 생성
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				Socket clientSocket = serverSocket.accept(); // 클라이언트 연결 대기
				System.out.println("클라이언트가 연결되었습니다.");

				// 클라이언트 식별자 생성
				InetSocketAddress clientAddress = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
				String clientIdString = clientAddress.getAddress().getHostAddress() + ":" + clientAddress.getPort()
						+ "_" + clientId++;

				// 클라이언트와 통신을 담당하는 쓰레드 생성 및 실행
				Thread thread = new Thread(new ClientThread(clientSocket, clientIdString));
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class ClientThread implements Runnable {
	private Socket clientSocket;
	private String clientId;

	public ClientThread(Socket clientSocket, String clientId) {
		this.clientSocket = clientSocket;
		this.clientId = clientId;
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			while (true) {
				// 클라이언트와의 통신 처리
				String message = in.readLine();
				if (message == null) {
					break;
				}

				System.out.println(clientId + " : " + message);
				out.println("서버에서 보낸 메시지 : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close(); // 클라이언트 소켓 닫기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}