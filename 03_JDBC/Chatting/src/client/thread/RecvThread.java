package client.thread;

import java.io.File;
import java.util.HashMap;

import javax.swing.JOptionPane;

import client.ConnectClass;
import client.form.ChattingForm;
import client.form.DownloadForm;
import client.form.LoginForm;
import client.function.ListClass;
import client.function.LoginClass;

/**
 * 
 * @author ������
 *	switch Ʋ �����
 */

public class RecvThread extends Thread{
	ConnectClass con;
	LoginForm login;
	ChattingForm chat;
	public RecvThread(ConnectClass con,LoginForm login) {
		this.con = con;
		this.login = login;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				HashMap<String , Object> response = (HashMap<String , Object>)con.oin.readObject();
				if(response.isEmpty()) {
					break;
				}
				switch((int)response.get("protocol")) {
				
				case 1101:
					if(new LoginClass(login).loginProc(response)) {
						JOptionPane.showMessageDialog(login, "로그인 성공");
						login.setVisible(false);
						chat = new ChattingForm(con);
					}else {
						JOptionPane.showMessageDialog(login, "로그인 실패");
					}
					break;
				
				case 1201:
					chat.area.append((String)response.get("msg")+"\r\n");
					break;
				
				case 1301:
					if((boolean)response.get("isSuccess")==true) {
						JOptionPane.showMessageDialog(login, "파일업로드 성공");
					}else {
						JOptionPane.showMessageDialog(login, "파일업로드 실패");
					}
					break;
				
				case 1302:
					new ListClass(chat).setList(response);
					break;
			
				case 1303:
					chat.wait.setVisible(false);
					chat.wait=null;
					File dir = new DownloadForm(chat).downloadForm();
					if(dir!=null) {
						new DownloadBar(dir,chat,response).start();
					}
					break;
				}
			}
		} catch (Exception e) {
			try {
				con.in.close();
				con.out.close();
				con.oin.close();
				con.oout.close();
				con.socket.close();
			} catch (Exception e1) {}
		}
	}

}
