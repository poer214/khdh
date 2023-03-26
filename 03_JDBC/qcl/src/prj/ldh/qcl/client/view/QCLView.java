package prj.ldh.qcl.client.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import prj.ldh.qcl.client.connect.QCLConnect;
import prj.ldh.qcl.client.custom.TitleBar;
import prj.ldh.qcl.client.view.panel.LoginPanel;

public class QCLView extends JFrame {
	public QCLConnect connect;
	public LoginPanel loginForm;
	
	public QCLView() {
		initObject();
		initFrame();
	}
	
	// 객체 생성 및 연결
	private void initObject() {
		// 서버연결용 객체 생성
		connect = new QCLConnect(this);
		// 로그인폼 생성 & 추가
		loginForm = new LoginPanel(this,connect);
		this.add(loginForm,BorderLayout.CENTER);
	}
	
	// JFrame 기본 설정	
	private void initFrame() {
		// 윈도우 닫을 때 프로그램 종료하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 크기변경 불가
		setResizable(false);
		// 제목표시줄, 테두리 없애기
		setUndecorated(true);
		// 창 크기 설정
		setSize(412, 915);
		// 창이 가운데 위치하도록
		setLocationRelativeTo(null);
		// 타이틀바 생성
		new TitleBar(this);
		// 창 보여주기
        setVisible(true);
	}
	
	public LoginPanel getLoginForm() {
		return loginForm;
	}
}