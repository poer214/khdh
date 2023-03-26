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
		setLoginPn();
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

	// *** 로그인 페이지 ***
	private JPanel lgnPn;
	private JLabel lgnTitleLb;
	private GridBagConstraints c;
	private JTextField lgnIdFld;
	private JPasswordField lgnPwFld;
	private JButton lgnLoginBtn;
	private JButton lgnSignUpBtn;
	private JLabel lgnStateLb;
	private void setLoginPn() {
		ComponentSetter cs = new ComponentSetter();
		lgnPn = new JPanel(new GridBagLayout());
		c = cs.c();
		lgnTitleLb = cs.titleLb("로그인");
		lgnIdFld = cs.tf("아이디 입력");
		lgnPwFld = cs.pf("비밀번호 입력");
		lgnLoginBtn = cs.btn("로그인");
		lgnLoginBtn.addActionListener(new lgnBtnListener());
		lgnSignUpBtn = cs.btn("회원가입");
		lgnSignUpBtn.addActionListener(new lgnBtnListener());
		lgnStateLb = cs.stateLb(" ");
		
		
		lgnPn.add(lgnTitleLb,c);
		c.gridy++;
		lgnPn.add(lgnIdFld,c);
		c.gridy++;
		lgnPn.add(lgnPwFld,c);
		c.gridy++;
		lgnPn.add(lgnLoginBtn,c);
		c.gridy++;
		lgnPn.add(lgnSignUpBtn,c);
		c.gridy++;
		lgnPn.add(lgnStateLb,c);
		this.add(lgnPn,BorderLayout.CENTER);
	}
	private class lgnBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==lgnLoginBtn) {
				try {
					Session.loginMember = service.login(lgnIdFld.getText(), lgnPwFld.getText());
					if(Session.loginMember==null)
						lgnStateLb.setText("로그인 실패");
					else 
						lgnPn.setVisible(false);
				} catch (Exception e1) {
					lgnStateLb.setText("로그인 중 예외 발생");
					e1.printStackTrace();
				}
			} else {
				
			}
		}
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
