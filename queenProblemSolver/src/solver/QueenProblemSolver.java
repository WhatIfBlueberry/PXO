package solver;

import chessPieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QueenProblemSolver {

    private final Integer boardSize;
    private final String unicode;
    private ArrayList<Point> coordinates;
    private final Scanner scanner = new Scanner(System.in);

    public QueenProblemSolver() {
        ChessPiece chessPiece = gatherChessPieceInput();
        this.boardSize = gatherBoardSizeInput();
        this.unicode = chessPiece.getUnicode();
        solve(chessPiece);
    }

    public Integer getBoardSize() {
        return this.boardSize;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public ArrayList<Point> getPoints() {
        return this.coordinates;
    }

    private void solve(ChessPiece piece) {
        SolveablePiece solveablePiece = findSolutionModelForPiece(piece);
        this.coordinates = solveablePiece.solve(boardSize);
    }

    private SolveablePiece findSolutionModelForPiece(ChessPiece piece) {
        switch (piece) {
            case PAWN:
                return new Pawn();
            case QUEEN:
                return new Queen();
            case ROOK:
                return new Rook();
            case BISHOP:
                return new Bishop();
            case KNIGHT:
                return new Knight();
            case KING:
                return new King();
            default:
                throw new RuntimeException("Unknown Chess Piece");
        }
    }

    private ChessPiece gatherChessPieceInput() {
        System.out.print("Enter Chess Piece: ");
        try {
            String chessPiece = scanner.nextLine().toUpperCase();
            return ChessPiece.valueOf(chessPiece);
        } catch (Exception e) {
            System.out.println("Invalid Chess Piece, please use the english term");
            return gatherChessPieceInput();
        }
    }

    private Integer gatherBoardSizeInput() {
        System.out.print("Enter Board size: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Board size, please enter valid Integer");
            return gatherBoardSizeInput();
        }
    }
}
