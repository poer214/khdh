import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Tetris extends JFrame {

    private static final long serialVersionUID = 1L;
    private Board board;

    public Tetris() {
        board = new Board(this);
        add(board, BorderLayout.CENTER);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.getBoard().start();
    }
}