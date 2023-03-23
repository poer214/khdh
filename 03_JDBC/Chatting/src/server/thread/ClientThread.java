package server.thread;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import DB.CJDBC;
import server.function.ChatClass;
import server.function.DownloadClass;
import server.function.ListClass;
import server.function.LoginClass;
import server.function.SendHash;
import server.function.UploadClass;

public class ClientThread extends Thread{
	public AcceptThread accept;
	public Socket socket;
	public String name;
	
	public InputStream in;
	public OutputStream out;
	public ObjectInputStream oin;
	public ObjectOutputStream oout;
	
	HashMap<String,Object> response;
	
	public ClientThread(AcceptThread accept, Socket socket) throws Exception{
		this.accept = accept;
		this.socket = socket;
		
		in = socket.getInputStream();
		out = socket.getOutputStream();
		oin = new ObjectInputStream(in);
		oout = new ObjectOutputStream(out);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				HashMap<String , Object> request = (HashMap<String , Object>)oin.readObject();
				if(request.get("protocol") == null) {
					break;
				}
				int protocol = (int)request.get("protocol");
				System.out.println("클라이언트 요청  - protocol:" + protocol);
				switch(protocol) {
				
				case 1101: 
					response = new LoginClass(this).loginProc(request);
					new SendHash(this,response).send();
					break;
				
				case 1201:
					response = new ChatClass(this).chatProc(request);
					synchronized(accept.clients){
						for(int i =0;i<accept.clients.size();i++) {
							new SendHash(accept.clients.get(i),response).send();
						}
					}
					break;
				case 1301:
					response = new UploadClass(this).uploadProc(request);
					new SendHash(this,response).send();
					break;
				
				case 1302:
					response = new ListClass(this).listProc(request);
					new SendHash(this,response).send();
					break;
			
				case 1303:
					response = new DownloadClass(this).downloadProc(request);
					new SendHash(this,response).send();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(socket.getRemoteSocketAddress()+"클라이언트 종료");
			try {
				in.close();
				out.close();
				oin.close();
				oout.close();
				socket.close();
			} catch (Exception e1) {}
			synchronized(accept.clients) {
				accept.clients.remove(this);
			}
		}
	}


}


