package prj.ldh.qcl.client.custom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitleBar extends JPanel{
	private JFrame frame;
	private int x,y;
	public TitleBar(JFrame frame) {
		this.frame = frame; 
		this.setBackground(Color.BLACK);
		Font font = new Font("D2Coding",Font.BOLD,20);
		setLayout(new BorderLayout());
		JLabel title = new JLabel(" QChatLive");
		title.setForeground(Color.WHITE);
		title.setFont(font);
		JLabel exit = new JLabel("X ");
		exit.setForeground(Color.WHITE);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose(); // 프레임 종료
	            System.exit(0); // JVM 종료
			}
		});
		exit.setFont(font);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		add(title,BorderLayout.WEST);
		add(exit,BorderLayout.EAST);
		this.frame.add(this,BorderLayout.NORTH);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int newX = e.getXOnScreen() - x;
				int newY = e.getYOnScreen() - y;
				frame.setLocation(newX, newY);
			}
		});
	}
}
