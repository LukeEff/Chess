package io.github.lukeeff.chess.chesspiece;

import io.github.lukeeff.chess.Team;

public class Pawn extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Pawn(int rowPosition, int columnPosition, Team team) {
        super(rowPosition, columnPosition, false, false, false, false, "Pawn", "P", team);
    }
}
