package solveableChessPieces;

public class Rook extends GenericChessPiece {

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        return straightLineOccupied(board, row, col);
    }
}
