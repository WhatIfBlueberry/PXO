package solver;

import chessPieces.*;

import java.awt.*;
import java.util.ArrayList;

public enum ChessPiece {
    PAWN("\u2659", new Pawn()),
    QUEEN("\u2655", new Queen()),
    ROOK("\u2656", new Rook()),
    BISHOP("\u2657", new Bishop()),
    KNIGHT("\u2658", new Knight()),
    KING("\u2654", new King());

    private String unicode;
    private SolveablePiece solveablePiece;

    ChessPiece(String unicode, SolveablePiece solveablePiece) {
        this.unicode = unicode;
        this.solveablePiece = solveablePiece;

    }

    public ArrayList<Point> solve(int boardSize) {
        return this.solveablePiece.solve(boardSize);
    }

    public String getUnicode() {
        return this.unicode;
    }
}
