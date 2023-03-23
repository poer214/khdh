package client.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import client.form.ChattingForm;


public class DownloadBar extends Thread{
	File dir;
	JFrame frame;
	JProgressBar p;
	JLabel l1;
	ChattingForm chat;
	String fileName;
	HashMap<String,Object> response;
	ArrayList<byte[]> fileInfo;
	public DownloadBar(File dir,ChattingForm chat,HashMap<String,Object> response) {
		this.dir=dir;
		this.chat = chat;
		this.response=response;
		fileInfo = (ArrayList<byte[]>)response.get("file");
		fileName = (String)response.get("fileName");
				
		frame = new JFrame();
		p = new JProgressBar(0,fileInfo.size());
		p.setStringPainted(true);
		p.setValue(0);
		JPanel p1= new JPanel();
		Border border = BorderFactory.createTitledBorder("Downloading....");
		p.setBorder(border);
		p1.add(p);
		l1= new JLabel("다운로드중...");
		JPanel p2 = new JPanel();
		p2.add(l1);
		
		frame.dispose();
		frame.add("South",p2);
		frame.add("Center",p1);
		frame.setSize(300,130);
		frame.setVisible(true);
	}
	
	@Override
	public void run() {
		try {
			FileOutputStream fout = new FileOutputStream(dir.getPath()+"\\"+fileName);
			int num=1;
			for(int i = 0;i<fileInfo.size();i++) {
				fout.write(fileInfo.get(i));
				num=(i+1);
				p.setValue(num);
			}
			fout.close();
			l1.setText("다운로드 완료 !!!!");
		} catch (Exception e) {
		}
		
	}

}
