package prj.ldh.qcl.client.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class IdField extends JTextField {
	public static final String HINT ="이메일주소 입력";
	public IdField(int columns) {
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
        setText(HINT);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	setBorder(focusBorder);
                if (getText().equals(HINT)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
            	setBorder(defaultBorder);
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY);
                    setText(HINT);
                }
            }
        });
	}
}