package io.github.lukeeff.chess.chesspiece;

import io.github.lukeeff.chess.Team;

public class Rook extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Rook(int rowPosition, int columnPosition, Team team) {
        super(rowPosition, columnPosition, false, true, false, true, "Rook", "R", team);
    }
}
