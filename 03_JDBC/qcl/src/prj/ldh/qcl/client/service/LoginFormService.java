package prj.ldh.qcl.client.service;

import java.util.regex.Pattern;

import prj.ldh.qcl.client.custom.IdField;
import prj.ldh.qcl.client.custom.PwField;
import prj.ldh.qcl.client.view.panel.LoginPanel;
import prj.ldh.qcl.common.dto.Data;

public class LoginFormService {
	private LoginPanel loginForm;



	public LoginFormService(LoginPanel loginForm) {
		this.loginForm = loginForm;
	}
	
	
    
    public String loginInfoCheck(Data loginInfo) {
    	String res=null;
    	String emailRegex = "^\\S+@\\S+\\.\\S+$";
        Pattern pattern = Pattern.compile(emailRegex);
    	
        // 값을 입력하지 않은 경우
    	if(loginInfo.getId().equals(IdField.HINT) || loginInfo.getPw().equals(PwField.HINT))
    		res = "이메일 주소와 비밀번호를 입력해주세요.";
    	// 이메일 유효성 검사
    	else if(!pattern.matcher(loginInfo.getId()).matches())
    		res = "이메일 주소가 유효하지 않습니다.";
    	
    	return res;
    }
}