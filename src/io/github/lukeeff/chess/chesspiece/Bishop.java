package io.github.lukeeff.chess.chesspiece;

public class Bishop extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Bishop(int rowPosition, int columnPosition) {
        super(rowPosition, columnPosition, false, false, true, false, "Bishop", "B");
    }
}
