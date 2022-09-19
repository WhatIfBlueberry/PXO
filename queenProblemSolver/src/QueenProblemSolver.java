import java.util.Scanner;

public class QueenProblemSolver {

    private Scanner scanner = new Scanner(System.in);

    private ChessPiece chessPiece;
    private Integer boardSize;

    public QueenProblemSolver() {
        gatherUserInput();
        System.out.println(this.chessPiece);
        System.out.println(this.boardSize);
    }

    private void gatherUserInput() {
        this.chessPiece = gatherChessPieceAsEnum();
        this.boardSize = gatherBoardSizeAsInteger();
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
