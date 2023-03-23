package server.function;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import server.thread.ClientThread;


public class ListClass {
	ClientThread clientT;
	public ListClass(ClientThread clientT) {
		this.clientT = clientT;
	}
	
	public HashMap<String,Object> listProc(HashMap<String, Object> request){
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		File file = new File("src/server/upload/");
		File[] files = file.listFiles();
		ArrayList<String> v = new ArrayList();
		for(int i = 0;i<files.length;i++) {
			v.add(files[i].getName());
		}
		System.out.println(clientT.socket.getRemoteSocketAddress()+"클라이언트 파일리스트 요청");
		response.put("protocol", 1302);
		response.put("fileList", v);
		
		return response;
	}

}
