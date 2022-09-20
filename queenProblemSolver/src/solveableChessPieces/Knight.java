package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public class Knight implements SolveablePiece {
    @Override
    public ArrayList<Point> solve(Integer boardSize) {
        ArrayList<Point> ret = new ArrayList<>();
        if (boardSize == 2) {
            for (int x = 0; x < boardSize; x++) {
                for (int y = 0; y < boardSize; y++) {
                    ret.add(new Point(x, y));
                }
            }
            return ret;
        }
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        ret.add(new Point(x, y));
                    } else {
                        ret.add(new Point(x, y + 1));
                    }
                }
            }
        }
        return ret;
    }
}
