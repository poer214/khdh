package prj.ldh.qcl.server.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QCLServer {
	public static final int PORT = 9000;
	ServerSocket ss;
	Socket client;
	Map<Socket,ReceiveThread> clients;
	ObjectMapper objectMapper = new ObjectMapper();
	BufferedReader in;
	PrintWriter out;
	
	public QCLServer() {
		clients = new HashMap<>();
		try {
			System.out.println("서버시작");
			ss = new ServerSocket(PORT);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				System.out.println(InetAddress.getLocalHost()+":"+PORT+" - 접속 대기중");
				client = ss.accept();
				System.out.println("getInetAddress : "+client.getInetAddress());
				System.out.println("getHostName : "+client.getInetAddress().getHostName());
				System.out.println("getPort : "+client.getPort());
				System.out.println("isConnected : "+client.isConnected());
				ReceiveThread thread = new ReceiveThread(client);
				clients.put(client,thread);
//				String message = sc.nextLine();
//				Data requestData = new Data("message", message);
//				out.println(objectMapper.writeValueAsString(requestData));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new QCLServer();
	}
}