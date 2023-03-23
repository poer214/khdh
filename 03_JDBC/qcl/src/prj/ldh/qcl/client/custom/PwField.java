package prj.ldh.qcl.client.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class PwField extends JPasswordField {
	public PwField(int columns) {
		super(columns);
		setDocument(new JTextFieldLimit(30)); // 글자수 제한
        setBorder(BorderFactory.createCompoundBorder(
        		getBorder(),
            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        ));
        setFont(new Font("D2Coding", Font.PLAIN, 15)); // 폰트 설정
        setBackground(Color.WHITE); // 배경색 설정
        setForeground(Color.BLACK); // 전경색 설정
        setCaretColor(Color.BLACK); // 캐럿 색상 설정
        setPreferredSize(new Dimension(260, 50)); // 크기 설정
        Border defaultBorder = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(200, 200, 200)), // 외곽선 설정
	            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        );
        Border focusBorder = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0, 0, 0)), // 외곽선 설정
	            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        );
        setBorder(defaultBorder);
        setForeground(Color.GRAY);
        setEchoChar((char) 0); // 마스킹 문자 제거
        String hint = "비밀번호 입력";
        setText(hint);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	setBorder(focusBorder);
                if (Arrays.equals(getPassword(), hint.toCharArray())) {
                    setText("");
                    setForeground(Color.BLACK);
                    setEchoChar('●'); // 마스킹 문자 설정
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
            	setBorder(defaultBorder);
                if (getPassword().length == 0) {
                    setForeground(Color.GRAY);
                    setEchoChar((char) 0);
                    setText(hint);
                }
            }
        });
	}
}