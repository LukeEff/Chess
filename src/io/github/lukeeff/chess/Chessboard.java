package io.github.lukeeff.chess;

import io.github.lukeeff.chess.chesspiece.ChessPiece;

/**
 * This is the class responsible for initializing a chessboard.
 */
public class Chessboard {

    private final int rows;
    private final int columns;
    private final ChessPiece[][] board;

    public Chessboard(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        board = new ChessPiece[rows][columns];
    }

    public int getRowSize() {
        return rows;
    }

    public int getColumnSize() {
        return columns;
    }

    public ChessPiece[][] getBoard() {
        return board;
    }

}
