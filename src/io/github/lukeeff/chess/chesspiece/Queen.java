package io.github.lukeeff.chess.chesspiece;

public class Queen extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Queen(int rowPosition, int columnPosition, String name, String initial) {
        super(rowPosition, columnPosition, false, true, true, true, "Queen", "Q");
    }
}
