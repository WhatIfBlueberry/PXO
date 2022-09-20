package external;

import solver.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JFrame {
    private final int boardSize;
    private final ArrayList<Point> solutions;
    private final String unicode;
    private ChessLabel[] labels;

    public Board(int boardSize, ChessPiece chessPiece, ArrayList<Point> solutions) {
        this.boardSize = boardSize;
        this.unicode = chessPiece.getUnicode();
        this.solutions = solutions;
        labels = new ChessLabel[this.boardSize * this.boardSize];
    }

    public void display() {
        setTitle("Queen Problem Solver");
        fillLabel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(this.boardSize, this.boardSize));
        addLabelsToContentPane(contentPane);
        setSize(75 * this.boardSize, 75 * this.boardSize);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addLabelsToContentPane(Container contentPane) {
        int row = -1;
        for (int i = 0; i < labels.length; i++) {
            if (i % this.boardSize == 0) row++;
            labels[i].set(i, row, this.boardSize);
            contentPane.add(labels[i]);
        }
    }

    private void fillLabel() {
        int totalFields = this.boardSize * this.boardSize;
        for (int pos = 0; pos < totalFields; pos++) {
            labels[pos] = new ChessLabel("");
        }
        this.solutions.stream().map(this::convertPointToLabelPosition).forEach(pos -> labels[pos] = new ChessLabel(this.unicode));
    }

    /**
     * @param p one of the solution-pieces
     * @return returns position in respect to the labels-array
     */
    private int convertPointToLabelPosition(Point p) {
        return ((p.x * this.boardSize) + p.y);
    }
}
