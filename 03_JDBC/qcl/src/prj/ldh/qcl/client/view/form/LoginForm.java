package prj.ldh.qcl.client.view.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import prj.ldh.qcl.client.connect.QCLConnect;
import prj.ldh.qcl.client.custom.CustomButtonA;
import prj.ldh.qcl.client.custom.IdField;
import prj.ldh.qcl.client.custom.PwField;
import prj.ldh.qcl.client.service.LoginFormService;
import prj.ldh.qcl.client.view.QCLView;
import prj.ldh.qcl.common.dto.Data;

public class LoginForm extends JPanel implements ActionListener{
	private final String LOGIN_BTN = "로그인";
	private final String JOIN_BTN = "회원가입";
	private final String FIND_BTN = "이메일 / 비밀번호 찾기";
	private QCLView view;
	private QCLConnect connect;
	private JLabel titleLabel;
	private IdField idField;
	private PwField pwField;
	private CustomButtonA loginBtn;
	private CustomButtonA joinBtn;
	private CustomButtonA findBtn;
	private JLabel stateLabel;
	private Dimension ButtonSize;
	private LoginFormService service;
	private GridBagConstraints c;
	private Font titleLabelFont;
	private Font stateLabelFont;
	
	public LoginForm(QCLView view, QCLConnect connect) {
		this.view = view;
		this.connect = connect;
		initPanel();
		joinBtn.requestFocusInWindow();
	}
	
	private void initPanel() {
		// 레이아웃 설정
		setLayout(new GridBagLayout());

		// 객체 생성
		stateLabel = new JLabel(" ");
		titleLabel = new JLabel("QChatLive 로그인");
		loginBtn = new CustomButtonA(LOGIN_BTN);
		joinBtn = new CustomButtonA(JOIN_BTN);
		findBtn = new CustomButtonA(FIND_BTN);
		idField = new IdField(30);
		pwField = new PwField(30);
		ButtonSize = new Dimension(260, 50);
		titleLabelFont = new Font("D2Coding", Font.BOLD, 30);
		stateLabelFont = new Font("D2Coding", Font.ITALIC, 12);
		// GridBagConstraints(int gridx, int gridy,
        // int gridwidth, int gridheight,
        // double weightx, double weighty,
        // int anchor, int fill,
        // Insets insets, int ipadx, int ipady)
		c = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(10, 0, 10, 0), 0, 0);
		service = new LoginFormService(this);
		
		// 컴포넌트 세팅
		titleLabel.setFont(titleLabelFont);
		loginBtn.setPreferredSize(ButtonSize);
		joinBtn.setPreferredSize(ButtonSize);
		findBtn.setPreferredSize(ButtonSize);
		joinBtn.setFocusable(true);
//		loginButton.addActionListener(new LoginEvent(this));
		stateLabel.setForeground(Color.red);
		stateLabel.setFont(stateLabelFont);
		
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		findBtn.addActionListener(this);
		
		addComponent();
	}
	
	private void addComponent() {
		this.add(titleLabel, c);	c.gridy++;
		this.add(idField, c);		c.gridy++;
		this.add(pwField, c);		c.gridy++;
		this.add(loginBtn, c);	c.gridy++;
		this.add(joinBtn, c);	c.gridy++;
		this.add(findBtn, c);	c.gridy++;
		this.add(stateLabel, c);
	}
	
	public void setStateLabel(String text) {
		stateLabel.setText(text);
	}

	public JLabel getStateLabel() {
		return stateLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case LOGIN_BTN:
			stateLabel.setText(" ");
			Data loginData = new Data("login",idField.getText(),pwField.getText());
			String res = service.loginInfoCheck(loginData);
			if(res==null)
				connect.connectToServer(loginData);
			else
				stateLabel.setText(res);
			break;
		case JOIN_BTN:break;
		case FIND_BTN:break;
		}
	}
}