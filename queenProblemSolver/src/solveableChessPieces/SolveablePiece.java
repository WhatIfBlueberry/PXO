package solveableChessPieces;

import java.awt.*;
import java.util.ArrayList;

public interface SolveablePiece {
    ArrayList<Point> solve(Integer boardSize);
}
