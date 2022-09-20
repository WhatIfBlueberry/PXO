package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public class Bishop implements SolveablePiece {
    @Override
    public ArrayList<Point> solve(Integer boardSize) {
        ArrayList<Point> ret = new ArrayList<>();
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if ((x == 0 || x == boardSize - 1) && y != 0) {
                    ret.add(new Point(x, y));
                }
            }
        }
        return ret;
    }
}
