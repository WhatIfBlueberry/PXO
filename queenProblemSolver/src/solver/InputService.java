package solver;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner = new Scanner(System.in);

    public Integer gatherBoardSizeInput() {
        System.out.print("Enter Board size: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Board size, please enter valid Integer");
            return gatherBoardSizeInput();
        }
    }

    public ChessPiece gatherChessPieceInput() {
        System.out.print("Enter Chess Piece: ");
        try {
            String chessPiece = scanner.nextLine().toUpperCase();
            return ChessPiece.valueOf(chessPiece);
        } catch (Exception e) {
            System.out.println("Invalid Chess Piece, please use the english term");
            return gatherChessPieceInput();
        }
    }
}
