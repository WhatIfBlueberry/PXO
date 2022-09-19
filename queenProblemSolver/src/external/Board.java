package external;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JFrame {
    private final int boardSize;
    private final ArrayList<Point> pieces;
    private final String unicode;
    private ChessLabel[] labels;

    public Board(int boardSize, ArrayList<Point> pieces, String unicode) {
        this.boardSize = boardSize;
        this.pieces = pieces;
        this.unicode = unicode;
        labels = new ChessLabel[this.boardSize * this.boardSize];
    }

    public void display() {
        setTitle("QueenProblem-Solver");
        fillLabel();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(this.boardSize, this.boardSize);
        contentPane.setLayout(gridLayout);

        int row = -1;
        for (int i = 0; i < labels.length; i++) {
            if (i % this.boardSize == 0) row++;
            labels[i].set(i, row, this.boardSize);
            contentPane.add(labels[i]);
        }

        setSize(75 * this.boardSize, 75 * this.boardSize);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void fillLabel() {
        int totalFields = this.boardSize * this.boardSize;
        for (int pos = 0; pos < totalFields; pos++) {
            labels[pos] = new ChessLabel("");
        }
        this.pieces.stream().map(this::parsePosition).forEach(pos -> labels[pos] = new ChessLabel(this.unicode));
    }

    private int parsePosition(Point p) {
        return ((p.x * this.boardSize) + p.y);
    }
}
