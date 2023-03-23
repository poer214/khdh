package server.function;

import java.util.ArrayList;
import java.util.HashMap;

import client.form.ChattingForm;
import server.thread.*;

/**
 * 
 * @author ������
 *	ä�� ���� ó�� Ŭ����
 */

public class ChatClass  {
	ClientThread client;
	public ChatClass(ClientThread client) {
		this.client = client;
	}
	
	public HashMap<String,Object> chatProc(HashMap<String, Object> request) {
		
		String msg = "[ "+ client.name + " ] " + (String)request.get("msg");
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("protocol", 1201);
		map.put("msg", msg);
		
		return map;
	
	}

}
