package edu.kh.jdbc.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import myResources.JTextFieldLimit;

public class ComponentSetter {
	public GridBagConstraints c() {
		return new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(10, 0, 10, 0), 0, 0);
	}
	
	public JButton btn(String text) {
		JButton btn = new JButton(text);
//		UIManager.put("Button.select", new Color(220, 220, 220));
//        UIManager.put("Button.focus", new Color(240, 240, 240));
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("", Font.BOLD, 15));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(260,50));
        return btn;
	}
	
	public JTextField tf(String hint) {
		JTextField tf = new JTextField(18);
		tf.setDocument(new JTextFieldLimit(18)); // 글자수 제한
        tf.setBorder(BorderFactory.createCompoundBorder(
            tf.getBorder(),
            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        ));
        tf.setFont(new Font("D2Coding", Font.PLAIN, 15)); // 폰트 설정
        tf.setBackground(Color.WHITE); // 배경색 설정
        tf.setForeground(Color.BLACK); // 전경색 설정
        tf.setCaretColor(Color.BLACK); // 캐럿 색상 설정
        tf.setPreferredSize(new Dimension(260, 50)); // 크기 설정
        Border defaultBorder = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(200, 200, 200)), // 외곽선 설정
	            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        );
        Border focusBorder = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0, 0, 0)), // 외곽선 설정
	            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        );
        tf.setBorder(defaultBorder);
        tf.setForeground(Color.GRAY);
        tf.setText(hint);
        tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	tf.setBorder(focusBorder);
                if (tf.getText().equals(hint)) {
                    tf.setText("");
                    tf.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
            	tf.setBorder(defaultBorder);
                if (tf.getText().isEmpty()) {
                    tf.setForeground(Color.GRAY);
                    tf.setText(hint);
                }
            }
        });
        return tf;
	}
	
	public JPasswordField pf(String hint) {
		JPasswordField pf = new JPasswordField(18);
		pf.setDocument(new JTextFieldLimit(18)); // 글자수 제한
		pf.setBorder(BorderFactory.createCompoundBorder(
				pf.getBorder(),
            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        ));
		pf.setFont(new Font("", Font.PLAIN, 15)); // 폰트 설정
		pf.setBackground(Color.WHITE); // 배경색 설정
		pf.setForeground(Color.BLACK); // 전경색 설정
		pf.setCaretColor(Color.BLACK); // 캐럿 색상 설정
		pf.setPreferredSize(new Dimension(260, 50)); // 크기 설정
        Border defaultBorder = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(200, 200, 200)), // 외곽선 설정
	            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        );
        Border focusBorder = BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(0, 0, 0)), // 외곽선 설정
	            BorderFactory.createEmptyBorder(5, 10, 5, 10) // 패딩
        );
        pf.setBorder(defaultBorder);
        pf.setForeground(Color.GRAY);
        pf.setEchoChar((char) 0); // 마스킹 문자 제거
        pf.setText(hint);
        pf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	pf.setBorder(focusBorder);
                if (Arrays.equals(pf.getPassword(), hint.toCharArray())) {
                	pf.setText("");
                	pf.setForeground(Color.BLACK);
                	pf.setEchoChar('●'); // 마스킹 문자 설정
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
            	pf.setBorder(defaultBorder);
                if (pf.getPassword().length == 0) {
                	pf.setForeground(Color.GRAY);
                	pf.setEchoChar((char) 0);
                	pf.setText(hint);
                }
            }
        });
        return pf;
	}
	
	public JLabel titleLb(String text) {
		JLabel lb = new JLabel(text);
		lb.setFont(new Font("D2Coding", Font.BOLD, 30));
		
		return lb;
	}

	public JLabel stateLb(String text) {
		JLabel lb = new JLabel(text);
		lb.setFont(new Font("D2Coding", Font.ITALIC, 12));
		lb.setForeground(Color.RED);
		
		return lb;
	}
}