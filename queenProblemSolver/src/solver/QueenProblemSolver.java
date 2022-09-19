package solver;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QueenProblemSolver {
    private final Integer boardSize;
    private final ChessPiece chessPiece;
    private ArrayList<Point> coordinates;
    private final Scanner scanner = new Scanner(System.in);

    public QueenProblemSolver() {
        this.chessPiece = gatherChessPieceInput();
        this.boardSize = gatherBoardSizeInput();
        solve();
    }
    public Integer getBoardSize() {
        return this.boardSize;
    }
    public ChessPiece getChessPiece() {
        return this.chessPiece;
    }
    public ArrayList<Point> getSolutions() {
        return this.coordinates;
    }
    private void solve() {
        this.coordinates = this.chessPiece.solve(boardSize);
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
