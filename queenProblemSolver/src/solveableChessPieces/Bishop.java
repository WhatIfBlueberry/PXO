package solveableChessPieces;

public class Bishop extends GenericChessPiece {

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        return !(checkRightDiagOccupied(board, row, col) || checkLeftDiagOccupied(board, row, col));
    }
}
