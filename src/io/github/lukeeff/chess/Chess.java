package io.github.lukeeff.chess;

import io.github.lukeeff.chess.chessboard.BoardPrint;
import io.github.lukeeff.chess.chessboard.Chessboard;
import io.github.lukeeff.chess.chesspiece.Pawn;
import io.github.lukeeff.chess.graphics.ChessGraphics;

public class Chess {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private final Chessboard chessboard;

    public Chess() {
        BoardPrint boardPrint = new BoardPrint();

        for(int i = 0; i < boardPrint.getRows(); i++) {
            boardPrint.addPiece(new Pawn(i,1, Team.BLACK));
            boardPrint.addPiece(new Pawn(i,6, Team.WHITE));
        }

        this.chessboard = new Chessboard(boardPrint);
        ChessGraphics graphics = new ChessGraphics(this, 500,500);
        System.out.println(chessboard);
    }

    public static void main(String[] args) {
        new Chess();
    }

    public Chessboard getChessboard() {
        return chessboard;
    }
}
