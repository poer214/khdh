package client.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import client.form.ChattingForm;


public class ListEvent implements ActionListener {
	ChattingForm chatF;
	public ListEvent(ChattingForm chatF) {
		this.chatF = chatF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("protocol", 1302);
		
		try {
			chatF.con.oout.writeObject(map);
		} catch (IOException e1) {
			try {
				chatF.con.in.close();
				chatF.con.out.close();
				chatF.con.oin.close();
				chatF.con.oout.close();
				chatF.con.socket.close();
			} catch (IOException e2) {
			}
		}
	}
	
	

}
