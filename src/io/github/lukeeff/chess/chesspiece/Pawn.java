package io.github.lukeeff.chess.chesspiece;

public class Pawn extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Pawn(int rowPosition, int columnPosition) {
        super(rowPosition, columnPosition, false, false, false, false, "Pawn", "P");
    }
}
