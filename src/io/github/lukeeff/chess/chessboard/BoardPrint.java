package io.github.lukeeff.chess.chessboard;

import io.github.lukeeff.chess.chesspiece.ChessPiece;

import java.util.Arrays;

/**
 * Blueprint for chessboard.
 *
 */
public class BoardPrint {

    private int rows;
    private int columns;
    private ChessPiece[][] board;

    public BoardPrint() {
        this(8,8);
    }

    public BoardPrint(final int rows, final int columns) {
        this(new ChessPiece[rows][columns]);
    }

    public BoardPrint(final ChessPiece[][] board) {
        this.board = board;
        this.rows = board.length;
        this.columns = board[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ChessPiece[][] getBoard() {
        return board;
    }

    public void setRows(int rows) {
        this.rows = rows;
        setBoard(Arrays.copyOf(board, rows));
    }

    public void setColumns(int columns) {
        this.columns = columns;
        for(int i = 0; i < getRows(); i++) {
            getBoard()[i] = Arrays.copyOf(getBoard()[i], columns);
        }
    }

    public void setBoard(ChessPiece[][] board) {
        this.board = board;
        rows = board.length;
        columns = board[0].length;
    }

    public void addPieces(ChessPiece[] pieces) {
        for(ChessPiece piece : pieces) {
            addPiece(piece);
        }
    }

    public void addPiece(ChessPiece piece) {
        getBoard()[piece.getRowPosition()][piece.getColumnPosition()] = piece;
    }

    /**
     * Inserts a piece at a target position.
     *
     * @param row the row to have the piece inserted at.
     * @param column the column to have to piece inserted at.
     * @param piece the piece to be inserted.
     */
    public void insertPiece(int row, int column, ChessPiece piece) {
        getBoard()[row][column] = piece;
    }

    /**
     * Inserts a row of pieces. Will throw array out of bounds exception if there are too many pieces.
     *
     * @param pieces an array of pieces to be inserted onto the board.
     * @param column the column where the row will be inserted.
     * @see #safeInsertRow(ChessPiece[], int) for insertion that will cut-off extra pieces.
     */
    public void insertRow(ChessPiece[] pieces, int column) {
        for(int i = 0; i < getRows(); i++) {
            getBoard()[i][column] = pieces[i];
        }
    }

    /**
     * Inserts a column of pieces. Will throw array out of bounds exception if there are too many pieces.
     *
     * @param pieces an array of pieces to be inserted onto the board.
     * @param row the row where the column will be inserted.
     * @see #safeInsertColumn(ChessPiece[], int) for insertion that will cut-off extra pieces.
     */
    public void insertColumn(ChessPiece[] pieces, int row) {

    }

    /**
     * Inserts a column of pieces. Will throw array out of bounds exception if there are too many pieces.
     *
     * @param pieces an array of pieces to be inserted onto the board.
     * @param row the row where the column will be inserted.
     * @see #insertColumn(ChessPiece[], int) for insertion that does not check for inconsistent sizing.
     */
    public void safeInsertColumn(final ChessPiece[] pieces, final int row) {
        final int columns = Math.min(getRows(), pieces.length);
        for(int i = 0; i < columns; i++) {
            getBoard()[row][i] = pieces[i];
            pieces[i].setPosition(row, i);
        }
    }

    /**
     * Inserts a row of pieces onto the chessboard.
     *
     * @param pieces an array of pieces to be inserted onto the board.
     * @param column the column where the row will be inserted.
     * @see #insertRow(ChessPiece[], int) for insertion that does not check for inconsistent sizing.
     */
    public void safeInsertRow(final ChessPiece[] pieces, final int column) {
        final int rows = Math.min(getColumns(), pieces.length);
        for(int i = 0; i < rows; i++) {
            getBoard()[i][column] = pieces[i];
            pieces[i].setPosition(i,column);
        }
    }
}
