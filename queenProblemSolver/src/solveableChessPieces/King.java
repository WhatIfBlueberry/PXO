package solveableChessPieces;

public class King extends GenericChessPiece {

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        for (int x = -1; x <= 1; x++) {
            if (!(row - x < 0 || row - x >= board.length)) {
                for (int y = -1; y <= 1; y++) {
                    if (!(col - y < 0 || col - y >= board.length) && (x != 0 && y != 0)) {
                        if (board[row - x][col - y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
