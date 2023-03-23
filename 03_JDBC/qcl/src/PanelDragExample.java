import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDragExample {
    private static int x, y;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Drag Example");
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - x;
                int newY = e.getYOnScreen() - y;
                frame.setLocation(newX, newY);
            }
        });
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}