package solver;

import external.Board;

public class Main {
    public static void main(String[] args) {
        InputService input = new InputService();
        ChessPiece chessPiece = input.gatherChessPieceInput();
        Integer boardSize = input.gatherBoardSizeInput();
        QueenProblemSolver solver = new QueenProblemSolver(boardSize, chessPiece);
        Board board = new Board(boardSize, chessPiece, solver.getSolutions());
        board.display();
    }
}