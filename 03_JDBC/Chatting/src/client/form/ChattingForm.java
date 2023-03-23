package client.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.ConnectClass;
import client.event.ChatEvent;
import client.event.DownloadEvent;
import client.event.ListEvent;
import client.event.UploadEvent;

public class ChattingForm extends JFrame{
	public ConnectClass con;
	public WaitingForm wait;
	JButton upBtn,listB,downBtn;
	public JComboBox listBox;
	public JTextArea area;
	JScrollPane sp;
	public JTextField field;
	
	public ChattingForm(ConnectClass con) {
		this.con = con;
		
		this.setLayout(new BorderLayout());
		
		upBtn = new JButton("업로드");
		listB = new JButton("파일목록");
		downBtn = new JButton("다운로드");
		
		UploadEvent upEvt = new UploadEvent(this);
		ListEvent listEvt = new ListEvent(this);
		DownloadEvent downEvt = new DownloadEvent(this);
		
		upBtn.addActionListener(upEvt);
		listB.addActionListener(listEvt);
		downBtn.addActionListener(downEvt);
		
		
		listBox = new JComboBox();
		area = new JTextArea();
		area.setEditable(false);
		sp = new JScrollPane(area); 
		
		field = new JTextField();
		ChatEvent chatEvt = new ChatEvent(this);
		field.addActionListener(chatEvt);
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(upBtn);
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(listB);
		JPanel p3 = new JPanel(new GridLayout(1,2));
		p3.add(p1);
		p3.add(p2);
		
		JPanel p4 = new JPanel(new BorderLayout());
		p4.add("Center",listBox);
		p4.add("East",downBtn);
		
		JPanel p5 =new JPanel(new GridLayout(2,1));
		p5.add(p3);
		p5.add(p4);
		
		this.add("North",p5);
		this.add("Center",sp);
		this.add("South",field);
		this.setSize(400,400);
		this.setVisible(true);
	}

}
