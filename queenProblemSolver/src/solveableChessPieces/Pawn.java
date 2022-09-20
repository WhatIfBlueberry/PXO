package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public class Pawn implements SolveablePiece {
    @Override
    public ArrayList<Point> solve(Integer boardSize) {
        ArrayList<Point> ret = new ArrayList<>();
        for (int x = 0; x < boardSize; x++) {
            if (x % 2 == 0) {
                for (int y = 0; y < boardSize; y++) {
                    ret.add(new Point(x, y));
                }
            }
        }
        return ret;
    }
}
