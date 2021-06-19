package io.github.lukeeff.chess;

import io.github.lukeeff.chess.chessboard.BoardPrint;
import io.github.lukeeff.chess.chessboard.Chessboard;
import io.github.lukeeff.chess.chesspiece.*;
import io.github.lukeeff.chess.graphics.ChessGraphics;

public class Chess {

    BoardPrint boardPrint = new BoardPrint();
    public static final int WIDTH = 500, HEIGHT = 400;
    private final Chessboard chessboard;
    private boolean isWhiteTurn;

    public Chess() {

        setUpBoard();
        this.isWhiteTurn = true;
        this.chessboard = new Chessboard(boardPrint);
        ChessGraphics graphics = new ChessGraphics(this, WIDTH, HEIGHT);
        System.out.println(chessboard);
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void setWhiteTurn(boolean whiteTurn) {
        isWhiteTurn = whiteTurn;
    }

    public static void main(String[] args) {
        new Chess();
    }

    public Chessboard getChessboard() {
        return chessboard;
    }

    private void setUpBoard() {
        setupPawns();
        boardPrint.addPiece(new Rook(0, 0, Team.BLACK));
        boardPrint.addPiece(new Rook(7, 0, Team.BLACK));
        boardPrint.addPiece(new Rook(0, 7, Team.WHITE));
        boardPrint.addPiece(new Rook(7, 7, Team.WHITE));
        boardPrint.addPiece(new Knight(1, 0, Team.BLACK));
        boardPrint.addPiece(new Knight(6, 0, Team.BLACK));
        boardPrint.addPiece(new Knight(1, 7, Team.WHITE));
        boardPrint.addPiece(new Knight(6, 7, Team.WHITE));
        boardPrint.addPiece(new Bishop(5, 0, Team.BLACK));
        boardPrint.addPiece(new Bishop(2, 0, Team.BLACK));
        boardPrint.addPiece(new Bishop(5, 7, Team.WHITE));
        boardPrint.addPiece(new Bishop(2, 7, Team.WHITE));
        boardPrint.addPiece(new King(4, 0, Team.BLACK));
        boardPrint.addPiece(new King(4, 7, Team.WHITE));
        boardPrint.addPiece(new Queen(3, 0, Team.BLACK));
        boardPrint.addPiece(new Queen(3, 7, Team.WHITE));
    }

    private void setupPawns() {
        for(int i = 0; i < boardPrint.getRows(); i++) {
            boardPrint.addPiece(new Pawn(i,1, Team.BLACK));
            boardPrint.addPiece(new Pawn(i,6, Team.WHITE));
        }
    }
}