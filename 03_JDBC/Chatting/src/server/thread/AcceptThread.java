package server.thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DB.CJDBC;
import server.ChatServer;

public class AcceptThread extends Thread{
	ChatServer main;
	
	public ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	public CJDBC db = new CJDBC();
	public Connection con = db.getCon();
	public String sql = "select * from member where m_id = ? and m_pw = ? ";
	public PreparedStatement pstmt;
	
	public AcceptThread(ChatServer main) {
		pstmt = db.getPSTMT(sql);
		this.main = main;
	}
	
	@Override
	public void run() {
		System.out.println("::: 채팅서버 시작 - 접속 대기 :::");
		while(true) {
			String ip="";
			try {
				Socket socket = main.server.accept();
				ip = socket.getRemoteSocketAddress().toString();
				System.out.println("[ 클라이언트 접속 ] - "+socket.getRemoteSocketAddress());
				ClientThread ct = new ClientThread(AcceptThread.this,socket);
				clients.add(ct);
				ct.start();
			} catch (Exception e) {
				System.out.println("[ "+ip+" ] 접속 오류!! ");
			}
		}
	}
}
