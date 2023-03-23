package client.form;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.ConnectClass;
import client.event.LoginEvent;


public class LoginForm extends JFrame{
	public JTextField idF;
	public JPasswordField pwF;
	JButton loginBtn;
	JLabel logoL;
	public ConnectClass con;
	
	public LoginForm(ConnectClass con) {
		this.con = con;
		this.setLayout(new BorderLayout());
		
		JLabel idL = new JLabel("아아디    : ");
		JLabel pwL = new JLabel("비밀번호 : ");
		
		idF = new JTextField();
		pwF = new JPasswordField();
		LoginEvent lEvt = new LoginEvent(this);
		pwF.addActionListener(lEvt);
		
		loginBtn = new JButton("Login");
		loginBtn.addActionListener(lEvt);
		
		JPanel p1 = new JPanel(new GridLayout(2,1));
		p1.add(idL);
		p1.add(pwL);
		JPanel p2 = new JPanel(new GridLayout(2,1));
		p2.add(idF);
		p2.add(pwF);
		
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add("West",p1);
		p3.add("Center",p2);
		p3.add("East",loginBtn);
		
		logoL = new JLabel(new ImageIcon("C:\\Form\\image\\kanye.jpg"));

		this.add("Center",logoL);
		this.add("South",p3);
		this.setSize(300,400);
		this.setVisible(true);
	}

}
