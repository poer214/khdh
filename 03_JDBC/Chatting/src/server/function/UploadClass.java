package server.function;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import server.thread.ClientThread;


public class UploadClass {
	ClientThread clientT;
	
	public UploadClass(ClientThread clientT) {
		this.clientT = clientT;
	}
	
	public HashMap<String,Object> uploadProc(HashMap<String,Object> request) {
		HashMap<String,Object> response = new HashMap<String,Object>();
		ArrayList<byte[]> fileInfo = (ArrayList<byte[]>)request.get("file");
		String fileName = (String)request.get("fileName");
		boolean isSuccess = false;
		
		try {
			FileOutputStream fout = new FileOutputStream("src/server/upload/"+fileName);
			int num =0;
			for(int i = 0;i<fileInfo.size();i++) {
				fout.write(fileInfo.get(i));
				if(i%(int)(fileInfo.size()/100)==0) {
					if(num==100) {	
						System.out.println("다운로드 전송 상황 "+100+"% ...");
					}else if(num<100) {
						System.out.println("다운로드 전송 상황"+(++num)+"% ...");		
					}else {
						
					}
				}
			}
			System.out.println("파일전송 성공");
			isSuccess = true;
			fout.close();
		} catch (Exception e) {
			isSuccess = false;
		}
		response.put("protocol", 1301);
		response.put("isSuccess", isSuccess);
		return response;
	}

}
