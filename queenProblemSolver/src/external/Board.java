package external;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Board extends JFrame {
    private final int boardSize;
    private final ArrayList<Point> pieces;
    private final String unicode;


    //Initialise arrays to hold panels and images of the board

    private ChessLabel[] labels;

    public Board(int boardSize, ArrayList<Point> pieces, String unicode) {
        this.boardSize = boardSize;
        this.pieces = pieces;
        this.unicode = unicode;
        labels = new ChessLabel[this.boardSize * this.boardSize];
    } // Board()

    public void display() {
        setTitle("Queen Problem Solver");
        fillLabel();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(this.boardSize, this.boardSize);
        contentPane.setLayout(gridLayout);

        int row = -1;
        for (int i = 0; i < labels.length; i++) {
            if (i % this.boardSize == 0) row++; // increment row number
            labels[i].set(i, row);
            contentPane.add(labels[i]);
        } // i

        setSize(75 * this.boardSize, 75 * this.boardSize);
        setLocationRelativeTo(null);
        setVisible(true);
    } // display()

    private void fillLabel() {
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                int labelPosSingle = parsePosition(i, j);
                this.labels[labelPosSingle] = new ChessLabel("");
                if (isOnPoint(i, j)) {
                    this.labels[labelPosSingle] = new ChessLabel(this.unicode);
                }
            }
        }
    }

    private int parsePosition(int i, int j) {
        return ((i * this.boardSize) + j);
    }

    private boolean isOnPoint(int i, int j) {
        Point point = new Point(i, j);
        return this.pieces.contains(point);
    }

} // class Board
