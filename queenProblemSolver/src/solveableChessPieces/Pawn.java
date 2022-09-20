package solveableChessPieces;

public class Pawn extends GenericChessPiece {

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        return false;
    }
}
