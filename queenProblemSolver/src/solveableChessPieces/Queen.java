package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public class Queen implements SolveablePiece {

    @Override
    public ArrayList<Point> solve(Integer boardSize) {
        ArrayList<Point> ret = new ArrayList<>();
        int[][] board = solveNQueen(boardSize);
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (board[x][y] == 1) {
                    ret.add(new Point(x, y));
                }
            }
        }
        return ret;
    }

    public static int[][] solveNQueen(int n) {
        int[][] board = new int[n][n];
        if (solveNQueenUtil(board, 0) == false) {
            System.out.println("Solution does not exist");
            return null;
        }
        return board;
    }

    //return true if queen can be placed
    private static boolean solveNQueenUtil(int[][] board, int col) {
        if (col >= board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueenUtil(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    //is it safe to place queen at row, col
    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
