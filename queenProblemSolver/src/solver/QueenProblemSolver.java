package solver;

import chessPieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QueenProblemSolver {

    private final Integer boardSize;
    private final String unicode;
    private ArrayList<Point> cords;
    private final Scanner scanner = new Scanner(System.in);

    public QueenProblemSolver() {
        ChessPiece chessPiece = gatherChessPieceAsEnum();
        this.boardSize = gatherBoardSizeAsInteger();
        solve(chessPiece);
        this.unicode = chessPiece.getUnicode();
    }

    public Integer getBoardSize() {
        return this.boardSize;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public ArrayList<Point> getPoints() {
        return this.cords;
    }

    private void solve(ChessPiece piece) {
        SolveablePiece solveablePiece = findSolutionForPiece(piece);
        this.cords = solveablePiece.solve(boardSize);
    }

    private SolveablePiece findSolutionForPiece(ChessPiece piece) {
        switch (piece) {
            case PAWN:
                return new Pawn();
            case QUEEN:
                return new Queen();
            case ROOK:
                return new Rook();
            case BISHOP:
            case KNIGHT:
                return new Knight();
            case KING:
                return new King();
            default:
                throw new RuntimeException("Unknown Chess Piece");
        }
    }

    private ChessPiece gatherChessPieceAsEnum() {
        System.out.print("Enter Chess Piece: ");
        try {
            String chessPiece = scanner.nextLine().toUpperCase();
            return ChessPiece.valueOf(chessPiece);
        } catch (Exception e) {
            System.out.println("Invalid Chess Piece, please use the english term");
            return gatherChessPieceAsEnum();
        }
    }

    private Integer gatherBoardSizeAsInteger() {
        System.out.print("Enter Board size: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Board size, please enter valid Integer");
            return gatherBoardSizeAsInteger();
        }
    }
}
