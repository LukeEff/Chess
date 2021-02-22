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
     * @return false if piece would be out of board.
     */
    public static boolean movePiece(ChessPiece chessPiece, Chessboard chessboard, boolean isDiagonal, int[] change) {
        return false;
    }


    private static void updatePiece(ChessPiece chessPiece, Chessboard chessboard, int change[]) {
        int[] newPosition = { chessboard.getRowSize() + change[0], chessboard.getColumnSize() + change[1]};

        chessboard.getBoard()[newPosition[0]][newPosition[1]] = chessPiece;
    }







}
