package prj.ldh.qcl.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import prj.ldh.qcl.client.custom.CustomButtonA;
import prj.ldh.qcl.client.custom.IdField;
import prj.ldh.qcl.client.custom.PwField;
import prj.ldh.qcl.client.custom.TitleBar;
import prj.ldh.qcl.client.service.LoginEvent;

public class LoginView extends JFrame {
	public LoginView() {
		// JFrame 기본 설정
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
		JPanel centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		// Insets 위, 왼쪽, 아래, 오른쪽의 여백
		c.insets = new Insets(10, 0, 10, 0);

		JLabel loginLabel = new JLabel("QChatLive 로그인");
		loginLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		IdField idField = new IdField(30);
		PwField pwField = new PwField(30);
		CustomButtonA loginButton = new CustomButtonA("로그인");
		CustomButtonA joinButton = new CustomButtonA("회원가입");
		CustomButtonA findButton = new CustomButtonA("아이디 / 비밀번호 찾기");
		Dimension dim = new Dimension(260, 50);
		loginButton.setPreferredSize(dim);
		joinButton.setPreferredSize(dim);
		findButton.setPreferredSize(dim);
		joinButton.setFocusable(true);

		loginButton.addActionListener(new LoginEvent(idField,pwField));

		centerPanel.add(loginLabel, c);
		c.gridy++;
		centerPanel.add(idField, c);
		c.gridy++;
		centerPanel.add(pwField, c);
		c.gridy++;
		centerPanel.add(loginButton, c);
		c.gridy++;
		centerPanel.add(joinButton, c);
		c.gridy++;
		centerPanel.add(findButton, c);

//		centerPanel.setBackground(new Color(0,218,255));
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
		joinButton.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new LoginView();
	}

}