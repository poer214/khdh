package server.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import DB.CJDBC;
import server.thread.ClientThread;

public class LoginClass {
	ClientThread clientT;
	
	public LoginClass(ClientThread clientT) {
		this.clientT = clientT;
	}
	
	public HashMap<String,Object> loginProc(HashMap<String,Object> request) {
		HashMap<String,Object> response = new HashMap<String,Object>();
		
		boolean isSuccess=false;
		try {
			clientT.accept.pstmt.setString(1, (String)request.get("id"));
			clientT.accept.pstmt.setString(2, (String)request.get("pw"));
			ResultSet rs = clientT.accept.pstmt.executeQuery();
			rs.next();
			if(rs.getString("m_name")==null) {
				isSuccess=false;
			}else {
				clientT.name = rs.getString("m_name");
				isSuccess = true;
			}
		} catch (Exception e) {
			isSuccess = false;
		}
		
		response.put("protocol", 1101);
		response.put("isSuccess", isSuccess);
		
		return response;
	}

}
