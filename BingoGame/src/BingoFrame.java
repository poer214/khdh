import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BingoFrame extends JFrame {
	private final int BINGO_SIZE = 100;

//	Java Project : BingoGame
//
//	1. 빙고판 크기를 입력 받아, 그 크기 만큼의 행과 열을 가지는 2차원 배열(빙고판)을 생성하고
//	1부터 크기*크기 사이의 정수 난수를 무작위 배치.
//
//	2. 정수를 입력 받아 빙고판에서 일치하는 부분을 찾아 해당 부분의 숫자를 “★“로 변경하고
//	현재 빙고 카운트가 몇인지 출력.
//	단, 빙고판에 없는 정수를 입력한 경우 “다시 입력해주세요.“ 출력
//
//	3. 가로, 세로, 대각선 한 줄이 모두 “★“로 변경되어 있을 경우 빙고 카운트를 1 증가
//
//	4. 빙고카운트가 3이상이 되면 “***Bingo!***” 를 출력하고 프로그램 종료.
	public BingoFrame(int size) {
		this.setSize(size * BINGO_SIZE, size * BINGO_SIZE + 50);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}