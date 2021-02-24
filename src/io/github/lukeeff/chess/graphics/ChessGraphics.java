package io.github.lukeeff.chess.graphics;

import io.github.lukeeff.chess.Chess;
import io.github.lukeeff.chess.chessboard.Chessboard;
import io.github.lukeeff.chess.chesspiece.ChessPiece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChessGraphics {

    private final JFrame frame;
    private final Chess chess;
    private int width;
    private int height;
    ChessPanel panel = new ChessPanel(new GridBagLayout());

    public ChessGraphics(Chess chess, int width, int height) {
        this.chess = chess;
        this.width = width;
        this.height = height;
        File spriteFile = new File("./src/resources/sprites/white_pawn.png");
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(spriteFile);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        int row = sprite.getWidth();
        int column = sprite.getHeight();
        int pieceRow = (getWidth() / getBoard().getRowSize());
        int pieceColumn = (getHeight() / getBoard().getColumnSize());
        this.frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChessPanel(new GridBagLayout()));
        frame.add(panel);
        frame.setSize(9 * row,8 * column);
        frame.setVisible(true);
        updateBoard();
        frame.setVisible(true);



    }

    private void updateBoard() {
        Chessboard chessboard = getBoard();
        int counter = 0;
        ChessPiece[][] board = chessboard.getBoard();
        for(int i = 0; i < chessboard.getColumnSize(); i++) {
            for(int j = 0; j < chessboard.getRowSize(); j++) {
                ChessPiece piece = chessboard.getPiece(j, i);
                if(piece != null)
                    counter = putPieceOnBoard(piece, 0);
                //return;
            }
        }
    }

    private int putPieceOnBoard(ChessPiece piece, int count) {
        final int[] coordinates = getPieceLocation(piece.getRowPosition(), piece.getColumnPosition());
        final String spriteName = piece.getSpriteName();
        System.out.println(spriteName);
        int counter;
        Color backgroundColor = Color.WHITE;
        if(count == 1) {
            backgroundColor = Color.GRAY;
            counter = 0;
        } else {
            counter = 1;
        }
        try {

            File spriteFile = new File("./src/resources/sprites/" + spriteName);
            BufferedImage sprite = ImageIO.read(spriteFile);
            Graphics graphics = getFrame().getGraphics();
            JLabel label = new JLabel(new ImageIcon(sprite));
            label.setBackground(Color.BLUE);
           // label.setBackground(backgroundColor);
            panel.add(label);
            //panel.paintComponent(graphics, sprite, coordinates[0], coordinates[1]);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return counter;
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

    private int getWidth() {
        return width;
    }

    private int getHeight() {
        return height;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    private void setHeight(int height)  {
        this.height = height;
    }

    private int[] getPieceLocation(int row, int column) {

        int pieceRow = (getWidth() / getBoard().getRowSize());
        int pieceColumn = (getHeight() / getBoard().getColumnSize());
        return new int[] {(pieceRow * row), (pieceColumn * column)};
    }

    static class ChessPanel extends JPanel {

        public ChessPanel(GridBagLayout gridBagLayout) {
        }


        public Dimension getPreferredSize() {
            return new Dimension(450, 500);
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
}
