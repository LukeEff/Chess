package io.github.lukeeff.chess.graphics;

import io.github.lukeeff.chess.Chess;
import io.github.lukeeff.chess.chessboard.Chessboard;
import io.github.lukeeff.chess.chesspiece.ChessPiece;

import javax.swing.*;
import java.awt.*;

public class ChessGraphics {

    private final JFrame frame;
    private final Chess chess;
    private int width;
    private int height;

    public ChessGraphics(Chess chess, int width, int height) {
        this.chess = chess;
        this.width = width;
        this.height = height;
        this.frame = new JFrame("Chess");
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    private void updateBoard() {
        Chessboard chessboard = getBoard();
        ChessPiece[][] board = chessboard.getBoard();
        for(int i = 0; i < chessboard.getColumnSize(); i++) {
            for(int j = 0; j < chessboard.getRowSize(); j++) {
                ChessPiece piece = chessboard.getPiece(j, i);
                
            }
        }

    }

    public JFrame getFrame() {
        return frame;
    }

    private Chessboard getBoard() {
        return getChess().getChessboard();
    }

    private Chess getChess() {
        return chess;
    }

}
