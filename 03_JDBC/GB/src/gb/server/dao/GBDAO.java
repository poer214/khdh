package gb.server.dao;

import gb.common.dto.LoginDTO;
import gb.common.dto.MemberDTO;

public class GBDAO {
	// 임시데이터
	int memberNo = 1;
	String id = "id";
	String pw = "pw";
	String nm = "nm";
	
	public MemberDTO login(LoginDTO loginData) {
		if(loginData.getId().equals(id) && loginData.getPassword().equals(pw)) {
			return new MemberDTO(memberNo++,id+memberNo,pw,nm+memberNo);
		}
		return null;
	}
}