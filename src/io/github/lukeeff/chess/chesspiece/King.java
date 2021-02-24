package io.github.lukeeff.chess.chesspiece;

import io.github.lukeeff.chess.Team;

public class King extends ChessPiece {

    public King(int rowPosition, int columnPosition, Team team) {
        super(rowPosition, columnPosition, false, true, true, true, "King", "K", team);
    }
}
