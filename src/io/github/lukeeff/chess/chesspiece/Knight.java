package io.github.lukeeff.chess.chesspiece;

public class Knight extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Knight(int rowPosition, int columnPosition) {
        super(rowPosition, columnPosition, true, false, false, false, "Knight", "Kn");
    }
}
