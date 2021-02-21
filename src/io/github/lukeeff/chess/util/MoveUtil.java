package io.github.lukeeff.chess.util;

import io.github.lukeeff.chess.Chessboard;
import io.github.lukeeff.chess.chesspiece.ChessPiece;

/**
 * Utility class for handling chess piece movements
 */
public class MoveUtil {

    /**
     * Attempts to move ChessPiece from one position to another
     *
     * @param chessPiece the chess piece to move.
     * @param x number of rows to displace.
     * @param y number of columns to displace.
     * @return false if piece would be out of board.
     */
    public static boolean movePiece(ChessPiece chessPiece, Chessboard chessboard, boolean isDiagonal, int[] change) {
        if(isInBounds(chessPiece, chessboard, change)) {

        }
    }


    private static void updatePiece(ChessPiece chessPiece, Chessboard chessboard, int change[]) {
        int[][] newPosition = new int[chessboard.getRowSize() + change[0]][chessboard.getColumnSize() + change[1]];
        newPosition[]

    }

    /**
     * Checks if piece can move to some row.
     *
     * @param chessPiece the piece being moved.
     * @param chessboard the board the chess piece is in.
     * @param change the amount of change.
     * @return true if
     */
    private static boolean isInBounds(ChessPiece chessPiece, Chessboard chessboard, int[] change) {
        return isInBound(chessPiece.getRowPosition(), chessboard.getRowSize(), change[0]) &&
                isInBound(chessPiece.getColumnPosition(), chessboard.getColumnSize(), change[1]);
    }

    /**
     * Checks if piece position change is in bound.
     *
     * @param original original position.
     * @param max max position.
     * @param change change in position.
     * @return true if in bounds.
     */
    private static boolean isInBound(final int original, final int max, final int change) {
        final boolean withinLowerLimit = original + change > 0;
        final boolean withinUpperLimit = original + change < max + 1;

        return withinLowerLimit && withinUpperLimit;
    }





}
