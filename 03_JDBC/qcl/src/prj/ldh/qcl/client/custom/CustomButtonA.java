package prj.ldh.qcl.client.custom;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.UIManager;

public class CustomButtonA extends JButton{
	
	public CustomButtonA(String text) {
        super(text);
        UIManager.put("Button.select", new Color(220, 220, 220));
        UIManager.put("Button.focus", new Color(240, 240, 240));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(new Font("D2Coding", Font.BOLD, 15));
        setBorderPainted(false);
        setFocusPainted(false);
//        setContentAreaFilled(false);
    }

}
