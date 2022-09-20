package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public class Rook implements SolveablePiece {
    @Override
    public ArrayList<Point> solve(Integer boardSize) {
        ArrayList<Point> ret = new ArrayList<>();
        for (int x = 0; x < boardSize; x++) {
            ret.add(new Point(x, x));
        }
        return ret;
    }
}
