package client.function;

import java.util.ArrayList;
import java.util.HashMap;

import client.form.ChattingForm;


public class ListClass {
	ChattingForm chat;
	public ListClass(ChattingForm chat) {
		this.chat =chat;
	}
	
	public void setList(HashMap<String,Object> response) {
		chat.listBox.removeAllItems();
		ArrayList<String> list =(ArrayList<String>) response.get("fileList");
		for(int i = 0;i<list.size();i++) {
			chat.listBox.addItem(list.get(i));
		}
	}

}
