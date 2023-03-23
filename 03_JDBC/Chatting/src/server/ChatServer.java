package server;

import java.net.InetAddress;
import java.net.ServerSocket;

import server.thread.AcceptThread;


public class ChatServer {
	
	public ServerSocket server;
	
	public ChatServer() {
		try {
			server = new ServerSocket(8000);
			System.out.println("[ "+InetAddress.getLocalHost()+" ] - 서버소켓 생성");
		}catch(Exception e) {
			System.out.println("::: 서버 소켓생성 오류 :::");
			System.exit(0);
		}
		
		new AcceptThread(this).start();
	}

	public static void main(String[] args) {
		new ChatServer();
	}

}