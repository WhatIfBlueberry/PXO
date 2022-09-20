package solver;

import solveableChessPieces.*;

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
    private GenericChessPiece genericChessPiece;

    ChessPiece(String unicode, GenericChessPiece genericChessPiece) {
        this.unicode = unicode;
        this.genericChessPiece = genericChessPiece;
    }

    public ArrayList<Point> solve(int boardSize) {
        return this.genericChessPiece.solve(boardSize);
    }

    public String getUnicode() {
        return this.unicode;
    }
}
