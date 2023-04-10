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

public class LoginPanel extends JPanel {
	private JFrame mainFrame;

	public LoginPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		setLoginPn();
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

	private class lgnBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == lgnLoginBtn) {
				try {
					Session.loginMember = service.login(lgnIdFld.getText(), lgnPwFld.getText());
					if (Session.loginMember == null)
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

		lgnPn.add(lgnTitleLb, c);
		c.gridy++;
		lgnPn.add(lgnIdFld, c);
		c.gridy++;
		lgnPn.add(lgnPwFld, c);
		c.gridy++;
		lgnPn.add(lgnLoginBtn, c);
		c.gridy++;
		lgnPn.add(lgnSignUpBtn, c);
		c.gridy++;
		lgnPn.add(lgnStateLb, c);
		this.add(lgnPn, BorderLayout.CENTER);
	}
}