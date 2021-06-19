package io.github.lukeeff.chess.graphics;

import io.github.lukeeff.chess.Chess;
import io.github.lukeeff.chess.Team;
import io.github.lukeeff.chess.chessboard.Chessboard;
import io.github.lukeeff.chess.chesspiece.ChessPiece;
import io.github.lukeeff.chess.chesspiece.Pawn;
import javafx.scene.layout.BorderPane;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChessGraphics {

    private final Color tileWhite = Color.WHITE;
    private final Color tileBlack = Color.GRAY;
    private final JFrame frame;
    private final Chess chess;
    private int width;
    private int height;
    ChessPanel panel;
    public static ChessPiece selectedPiece;
    public ChessGraphics(Chess chess, int width, int height) {
        this.chess = chess;
        this.width = width;
        this.height = height;
        this.panel = new ChessPanel(new GridBagLayout(), chess.getChessboard());
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
        frame.setContentPane(new ChessPanel(new GridBagLayout(), chess.getChessboard()));
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        panel.setSize(8 * row, 8 * column);
        frame.setSize(8 * row,8 * column);
        placeBoardTile();
        frame.setVisible(true);
        frame.pack();
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

    private void placeBoardTile() {
        Chessboard chessboard = getBoard();
        for(int i = 0; i < chessboard.getColumnSize(); i++) {
            for (int j = 0; j < chessboard.getRowSize(); j++) {
                Color tileColor = ((i + j) % 2 == 0) ? tileWhite : tileBlack; //odd or even tile.
                JLabel chessTile = new ChessSquarePanel(new GridBagLayout(), chessboard, tileColor, j, i, chessboard.getPiece(j,i));
                panel.add(chessTile);
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

            final File spriteFile = new File("./src/resources/sprites/" + spriteName);
            final BufferedImage sprite = ImageIO.read(spriteFile);
            JLabel label = new JLabel(new ImageIcon(sprite));
            label.setBackground(Color.BLUE);
            label.setBackground(backgroundColor);
            label.setOpaque(true);
            panel.add(label);

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

    class ChessPanel extends JPanel {

        private final int width = 500;
        private final int height = 500;
        protected final Chessboard chessboard;

        public ChessPanel(GridBagLayout gridBagLayout, Chessboard chessboard) {
            this.chessboard = chessboard;
            super.setSize(width,height);
        }

        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    class ChessSquarePanel extends JLabel {
        private final int width;
        private final int height;
        private final int row;
        private final int column;
        private final Color color;
        private ChessPiece piece;


        public ChessSquarePanel(GridBagLayout gridBagLayout, Chessboard chessboard, Color color, int row, int column) {
            this(gridBagLayout, chessboard, color, row, column, null);
        }

        public ChessSquarePanel(GridBagLayout gridBagLayout, Chessboard chessboard, Color color, int row, int column, ChessPiece piece) {
            this.row = row;
            this.column = column;
            this.color = color;
            this.width = 440 / chessboard.getRowSize();
            this.height = 440 / chessboard.getColumnSize();
            this.piece = piece;
            setFields();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("Clicked");



                    if (selectedPiece != null) {
                        setIcon(new ImageIcon("./src/resources/sprites/" + selectedPiece.getSpriteName()));
                        selectedPiece = null;
                    }
                    if (piece != null && (chess.isWhiteTurn() && piece.getTeam() == Team.WHITE || !chess.isWhiteTurn() && piece.getTeam() == Team.BLACK)) {
                        setBackground(Color.blue);
                        setIcon(null);
                        selectedPiece = piece;
                    }

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(color);
                    if (selectedPiece != null) {
                        //setIcon(new ImageIcon("./src/resources/sprites/" + piece.getSpriteName()));
                    }
                }
            });
        }

        private void setFields() {
            if (piece != null) {
                setIcon(new ImageIcon("./src/resources/sprites/" + piece.getSpriteName()));
            }
            setBackground(color);
            setOpaque(true);
        }

        private void updateGraphics() {

        }

        public Dimension getPreferredSize() {
            return new Dimension(this.width, this.height);
        }

        public void setPiece(ChessPiece piece) {
            this.piece = piece;
            updateGraphics();
        }

        public ChessPiece getPiece() {
            return piece;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }
}
