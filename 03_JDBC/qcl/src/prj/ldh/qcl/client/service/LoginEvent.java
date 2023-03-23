package prj.ldh.qcl.client.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import prj.ldh.qcl.client.custom.IdField;
import prj.ldh.qcl.client.custom.PwField;

public class LoginEvent implements ActionListener{
	IdField idf;
	PwField pwf;
	String ip = "localhost";
	int port = 9000;
	public LoginEvent(IdField idf, PwField pwf) {
		this.idf = idf;
		this.pwf = pwf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		idf.getText();
		pwf.getPassword();
		
		try(Socket s = new Socket(ip,port)
			s.res){
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}