package solver;

import external.Board;

public class Main {
    public static void main(String[] args) {
        QueenProblemSolver solver = new QueenProblemSolver();
        Board board = new Board(solver.getBoardSize(), solver.getSolutions(), solver.getUnicode());
        board.display();
    }
}