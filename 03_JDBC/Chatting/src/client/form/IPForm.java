package client.form;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.ClientMain;
import client.ConnectClass;


public class IPForm extends JFrame{
	
	JLabel ipL,portL;
	public JTextField ipF,portF;
	JButton connectBtn;
	
	public IPForm() {
		
		JPanel p1 = new JPanel();
		ipL = new JLabel("IP : ");
		portL = new JLabel("PORT : " );
		p1.setLayout(new GridLayout(2,1));
		p1.add(ipL);
		p1.add(portL);
		
		JPanel p2 = new JPanel();
		ipF = new JTextField();
		portF = new JTextField();
		p2.setLayout(new GridLayout(2,1));
		p2.add(ipF);
		p2.add(portF);
		
		connectBtn = new JButton("접속");
		connectBtn.addActionListener(e->{
			if(ipF.getText().length()==0 || portF.getText().length()==0) {
				JOptionPane.showMessageDialog(IPForm.this, "아이피와 포트를 입력하세요.");
			}else {
				new ConnectClass(IPForm.this);
			}
			
		});
		
		JPanel p01 = new JPanel();
		p01.setLayout(new BorderLayout());
		p01.add("West",p1);
		p01.add("Center",p2);
		p01.add("East",connectBtn);
		p01.setBorder(BorderFactory.createEmptyBorder(50 , 10 , 50 , 10));
		this.add(p01);
		this.setSize(400,200);
		this.setVisible(true);
	}

}
