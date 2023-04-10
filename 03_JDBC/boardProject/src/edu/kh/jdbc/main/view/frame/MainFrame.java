package edu.kh.jdbc.main.view.frame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.kh.jdbc.common.ComponentSetter;
import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.main.model.service.MainService;
import myResources.TitleBar;

public class MainFrame extends JFrame {
	private MainService service = new MainService();
	
	public MainFrame() {
		initFrame();
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
		setSize(800, 640);
		// 창이 가운데 위치하도록
		setLocationRelativeTo(null);
		// 타이틀바 생성
		new TitleBar(this,"회원제 게시판");
		// 창 보여주기
		setVisible(true);
	}

	
	
	// *** 회원가입 페이지 ***
	JPanel signUpPn;
	JLabel suTitleLabel;
	JTextField suIdFld;
	JPasswordField suPwFld;
	JPasswordField suCfFld;
	JTextField suNmFld;
	
	
	
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
