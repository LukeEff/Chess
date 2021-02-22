package io.github.lukeeff.chess;

import io.github.lukeeff.chess.chesspiece.ChessPiece;
import io.github.lukeeff.chess.chesspiece.action.ChessMove;

import java.awt.*;

/**
 * This is the class responsible for initializing a chessboard.
 */
public class Chessboard {

    private final int rows;
    private final int columns;
    private final ChessPiece[][] board;

    public Chessboard(final int rows, final int columns) {
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

    /**
     * Processes a chess move.
     *
     * @param chessMove the chess move being performed.
     */
    public void processChessMove(final ChessMove chessMove) {
        if(validMove(chessMove)) {
            updateBoardPiece(chessMove);
        }
    }

    /**
     * Updates the positional data of a piece.
     *
     * @param chessMove the chess move being performed.
     */
    private void updateBoardPiece(final ChessMove chessMove) {
        final int newRow = chessMove.getRowChange() + chessMove.getPiece().getRowPosition();
        final int newColumn = chessMove.getColumnChange() + chessMove.getPiece().getColumnPosition();
        updateBoardPiece(newRow, newColumn, chessMove.getPiece());
    }

    /**
     * Updates the positional data of a piece.
     *
     * @param row the row the piece will be moved to.
     * @param column the column the piece will be moved to.
     * @param piece the piece that will be moved.
     */
    private void updateBoardPiece(final int row, final int column, final ChessPiece piece) {
        clearBoardPiece(piece);
        piece.setPosition(row, column);
        setBoardPiece(row, column, piece);
    }

    /**
     * Sets the positional data of a piece in the chessboard's array.
     *
     * @param row the row the piece will be moved to.
     * @param column the column the piece will be moved to.
     * @param piece the piece being moved.
     */
    private void setBoardPiece(final int row, final int column, final ChessPiece piece) {
        getBoard()[row][column] = piece;
    }

    /**
     * Clears a piece from a position in the chessboard by setting the reference of a target element to null.
     *
     * @param row the row position.
     * @param column the column position.
     */
    private void clearBoardPiece(final int row, final int column) {
        getBoard()[row][column] = null;
    }

    /**
     * Clears a piece from a position in the chessboard by setting the reference of a target element to null.
     *
     * @param piece the piece holding information about its coordinates.
     */
    private void clearBoardPiece(final ChessPiece piece) {
        clearBoardPiece(piece.getRowPosition(), piece.getColumnPosition());
    }

    /**
     * Checks if a move is valid.
     *
     * @param chessMove the chess move being performed
     * @return true if the move is valid.
     */
    private boolean validMove(final ChessMove chessMove) {
        return isInBounds(chessMove) && !hasObstacle(chessMove);
    }

    /**
     * Checks if anything is in the way of a piece.
     *
     * @param chessMove the chess move being performed.
     * @return true if an obstacle is present.
     */
    private boolean hasObstacle(final ChessMove chessMove) {
        final ChessPiece piece = chessMove.getPiece();
        if(piece.isJumper()) return false;
        final int origRow = piece.getRowPosition();
        final int origCol = piece.getColumnPosition();
        int[] obstacleRange;

        switch(chessMove.getDirection()) {
            case DIAGONAL:
                int[] rowObstacleRange = getOrder(origRow + chessMove.getRowChange(), origRow);
                obstacleRange = getOrder(origCol + chessMove.getColumnChange(), origCol);
                for(int i = rowObstacleRange[0] + 1, j = obstacleRange[0] + 1; i < obstacleRange[1] - 1; i++, j++) {
                    if(getBoard()[i][j] != null) return true;
                }
            case STRAIGHT:
                obstacleRange = getOrder(origCol + chessMove.getColumnChange(), origCol);
                for(int i = obstacleRange[0] + 1; i < obstacleRange[1] - 1; i++) {
                    if(getBoard()[origRow][i] != null) return true;
                }
            case SIDEWAYS:
                obstacleRange = getOrder(origRow + chessMove.getRowChange(), origRow);
                for(int i = obstacleRange[0] + 1; i < obstacleRange[1] - 1; i++) {
                    if(getBoard()[i][origCol] != null) return true;
                }
            default:
                System.err.println("Chess move " + chessMove.toString() + " does not have a " +
                        "defined direction and does not jump. Cannot check for obstacle. " +
                        "The piece will be permitted to pass without checking for obstacles.");
                return false;
        }
    }

    /**
     * Makes a sorted array where a and b are sorted in ascending order.
     *
     * @param a integer 1
     * @param b integer 2
     * @return a sorted array where a and b are sorted in ascending order.
     */
    private int[] getOrder(int a, int b) {
        final int low = Math.min(a, b);
        final int high = Math.max(a, b);
        return new int[]{low, high};
    }

    /**
     * Checks if piece can move to some position without falling off the chessboard.
     *
     * @param chessMove the move being performed.
     * @return true if the piece is in bounds.
     */
    private boolean isInBounds(final ChessMove chessMove) {
        return isInBounds(chessMove.getPiece(), chessMove.getRowChange(), chessMove.getColumnChange());
    }

    /**
     * Checks if piece can move to some position without falling off the chessboard.
     *
     * @param chessPiece the piece being moved.
     * @param rowChange row displacement.
     * @param columnChange column displacement.
     * @return true if the piece is in bounds.
     */
    private boolean isInBounds(final ChessPiece chessPiece, final int rowChange, final int columnChange) {
        return isInBound(chessPiece.getRowPosition(), getRowSize(), rowChange) &&
                isInBound(chessPiece.getColumnPosition(), getColumnSize(), columnChange);
    }

    /**
     * Checks if piece position change is in bound.
     *
     * @param original original position.
     * @param max max position.
     * @param change change in position.
     * @return true if in bounds.
     */
    private boolean isInBound(final int original, final int max, final int change) {
        final boolean withinLowerLimit = original + change > 0;
        final boolean withinUpperLimit = original + change < max + 1;

        return withinLowerLimit && withinUpperLimit;
    }

    public String toString() {
        Color green = Color.GREEN;
        final String nl = "\n";
        final String boardDimensions = green + "Board dimensions: " + nl;
        final String rows = green + "Number of rows: " + getRowSize() + nl;
        final String columns = green + "Number of columns: " + getRowSize() + nl;
        final String boardData = nl + green + "Board contents: " + nl + getChessBoardString();
        return boardDimensions + rows + columns + boardData;
     }

    /**
     * Makes a nice looking string to show what the chessboard looks like.
     *
     * @return a string representation of the chessboard
     */
     public String getChessBoardString() {
        StringBuilder boardString = new StringBuilder();
        for(int i = 0; i < getColumnSize(); i++) {
            boardString.append(Color.ORANGE).append("[");
            for(int j = 0; j < getRowSize(); j++) {
                boardString.append(getBoard()[j][i].getInitial()).append(", ");
            }
            boardString.append(Color.ORANGE).append("]\n");
        }
        return boardString.toString();
     }
}
