package io.github.lukeeff.chess.chesspiece;

import io.github.lukeeff.chess.Team;

public class Queen extends ChessPiece {
    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition          the row position of the piece.
     * @param columnPosition       the column position of the piece.
     */
    public Queen(int rowPosition, int columnPosition, Team team) {
        super(rowPosition, columnPosition, false, true, true, true, "Queen", "Q", team);
    }
}
