package io.github.lukeeff.chess.chesspiece;

public class Rook extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Rook(int rowPosition, int columnPosition) {
        super(rowPosition, columnPosition, false, true, false, true, "Rook", "R");
    }
}
