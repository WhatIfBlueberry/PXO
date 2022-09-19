import java.util.Scanner;

public class QueenProblemSolver {

    private Scanner scanner = new Scanner(System.in);

    public QueenProblemSolver() {
        ChessPiece chessPiece = gatherChessPieceAsEnum();
        Integer boardSize = gatherBoardSizeAsInteger();
        solve(chessPiece, boardSize);
    }

    private void solve(ChessPiece piece, Integer boardSize) {
        SolveablePiece solveablePiece = findSolutionForPiece(piece);
        solveablePiece.solve(boardSize);
    }

    private SolveablePiece findSolutionForPiece(ChessPiece piece) {
        switch (piece) {
            case PAWN:
            case QUEEN:
                return new Queen();
            case ROOK:
            case BISHOP:
            case KNIGHT:
            case KING:
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
