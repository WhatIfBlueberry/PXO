package solveableChessPieces;

public class Queen extends GenericChessPiece {
    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        if (straightLineOccupied(board, row, col)) return false;
        if (checkLeftDiagOccupied(board, row, col)) return false;
        if (checkRightDiagOccupied(board, row, col)) return false;
        return true;
    }


}
