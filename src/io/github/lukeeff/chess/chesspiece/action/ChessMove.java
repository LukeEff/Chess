package io.github.lukeeff.chess.chesspiece.action;

import io.github.lukeeff.chess.chesspiece.ChessPiece;
import io.github.lukeeff.chess.chesspiece.Direction;

public class ChessMove {

    private final int rowChange;
    private final int columnChange;
    private final ChessPiece piece;
    private final Direction direction;

    public ChessMove(final int rowChange, final int columnChange, final ChessPiece piece, final Direction direction) {
        this.rowChange = rowChange;
        this.columnChange = columnChange;
        this.piece = piece;
        this.direction = direction;
    }

    public int getRowChange() {
        return rowChange;
    }

    public int getColumnChange() {
        return columnChange;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public Direction getDirection() {
        return direction;
    }
}
