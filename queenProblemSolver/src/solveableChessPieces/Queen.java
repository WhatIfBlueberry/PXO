package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public class Queen implements SolveablePiece {

    ArrayList<Point> ret = new ArrayList<>();

    @Override
    public ArrayList<Point> solve(Integer boardSize) {
        var ret = new ArrayList<Point>();
        ret.add(new Point(1, 1));
        return ret;
    }
}
