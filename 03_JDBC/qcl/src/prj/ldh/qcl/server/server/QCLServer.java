package prj.ldh.qcl.server.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QCLServer {
	public static final int PORT = 9000;
	ServerSocket ss;
	Socket client;
	List<Socket> clients;
	ObjectMapper objectMapper = new ObjectMapper();
	BufferedReader in;
	PrintWriter out;
	
	public QCLServer() {
		clients = new ArrayList<>();
		System.out.println("서버시작");
		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				System.out.println(InetAddress.getLocalHost()+":"+PORT+" - 접속 대기중");
				client = ss.accept();
				Thread.sleep(1000);
				clients.add(client);
				new ReceiveThread(client);
//				String message = sc.nextLine();
//				Data requestData = new Data("message", message);
//				out.println(objectMapper.writeValueAsString(requestData));
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}