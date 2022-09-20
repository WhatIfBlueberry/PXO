package solver;

import java.awt.*;
import java.util.ArrayList;

public class QueenProblemSolver {
    private final Integer boardSize;
    private final ChessPiece chessPiece;
    private ArrayList<Point> coordinates;

    public QueenProblemSolver(Integer boardSize, ChessPiece chessPiece) {
        this.boardSize = boardSize;
        this.chessPiece = chessPiece;
        solve();
    }

    public ArrayList<Point> getSolutions() {
        return this.coordinates;
    }

    private void solve() {
        this.coordinates = this.chessPiece.solve(boardSize);
    }
}
