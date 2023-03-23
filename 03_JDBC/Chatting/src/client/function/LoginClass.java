package client.function;

import java.util.HashMap;

import javax.swing.JOptionPane;

import client.form.LoginForm;


public class LoginClass {
	LoginForm login;
	HashMap<String,Object> response;
	public LoginClass(LoginForm login) {
		this.login = login;
		this.response=response;
	}
	
	public boolean loginProc(HashMap<String,Object> response) {
		boolean bool = false;
		if((boolean)response.get("isSuccess")==true) {	
			bool = true;
		}else {
			bool = false;
		}
		
		return bool;
	}

}
