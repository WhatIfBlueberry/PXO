package solver;

public enum ChessPiece {
    PAWN("\u2659"),
    QUEEN("\u2655"),
    ROOK("\u2656"),
    BISHOP("\u2657"),
    KNIGHT("\u2658"),
    KING("\u2654");

    private String unicode;

    ChessPiece(String unicode) {
        this.unicode = unicode;
    }

    public String getUnicode() {
        return this.unicode;
    }
}
