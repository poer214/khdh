package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import client.form.IPForm;
import client.form.LoginForm;
import client.thread.RecvThread;


public class ConnectClass {
	IPForm ipForm;
	String ip;
	String port;
	public Socket socket;
	
	public InputStream in;
	public OutputStream out;
	public ObjectInputStream oin;
	public ObjectOutputStream oout;
	public LoginForm login ;
	
	public ConnectClass(IPForm ipForm) {
		this.ipForm = ipForm;
		
		ip = ipForm.ipF.getText();
		System.out.println("**** ip "+ip);
		port = ipForm.portF.getText();
		System.out.println("**** port "+port);
		int port =Integer.parseUnsignedInt(ipForm.portF.getText());
		try {
			socket = new Socket(ip,port);
			in = socket.getInputStream();
			out = socket.getOutputStream();
			oout = new ObjectOutputStream(out);
			oin = new ObjectInputStream(in);
		} catch (Exception e1) {
			System.exit(0);
		} 
		
		ipForm.setVisible(false);
		
		login = new LoginForm(this);
		new RecvThread(this, login).start();

	}

}
