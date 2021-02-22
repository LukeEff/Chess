package io.github.lukeeff.chess.chesspiece;

import java.awt.*;

/**
 * The GCF's of chess pieces!
 */
abstract public class ChessPiece {

    private int rowPosition;
    private int columnPosition;
    private final boolean jumper;
    private final boolean allowedBackwardsMove;
    private final boolean allowedDiagonalMove;
    private final boolean allowedSidewaysMove;
    private final String initial;
    private final String name;

    /**
     * Initializes a chess piece object.
     * @param rowPosition the row position of the piece.
     * @param columnPosition the column position of the piece.
     * @param jumper does the piece jump over pieces.
     * @param allowedBackwardsMove is piece allowed to move backwards.
     * @param allowedDiagonalMove is piece allowed to move diagonal.
     * @param allowedSidewaysMove is piece allowed to move sideways.
     */
    public ChessPiece(final int rowPosition, final int columnPosition, final boolean jumper, final boolean allowedBackwardsMove, final boolean allowedDiagonalMove, final boolean allowedSidewaysMove, final String name, final String initial) {
        this.jumper = jumper;
        this.columnPosition = columnPosition;
        this.rowPosition = rowPosition;
        this.allowedBackwardsMove = allowedBackwardsMove;
        this.allowedDiagonalMove = allowedDiagonalMove;
        this.allowedSidewaysMove = allowedSidewaysMove;
        this.initial = initial;
        this.name = name;
    }

    public boolean isJumper() {
        return jumper;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    public void setPosition(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
    }

    public boolean isAllowedBackwardsMove() {
        return allowedBackwardsMove;
    }

    public boolean isAllowedDiagonalMove() {
        return allowedDiagonalMove;
    }

    public boolean isAllowedSidewaysMove() {
        return allowedSidewaysMove;
    }

    public String getInitial() {
        return initial;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        final Color green = Color.GREEN;
        final String nl = "\n";
        final String name = green + "Name: " + getName() + nl;
        final String initial = green + "Initial: " + getInitial() + nl;
        final String rowPos = green + "Row position: " + getRowPosition() + nl;
        final String colPos = green + "Column position: " + getColumnPosition() + nl;
        final String backwards = green + "allowedBackwardsMove: " + isAllowedBackwardsMove() + nl;
        final String diagonal = green + "allowedDiagonalMove: " + isAllowedDiagonalMove() + nl;
        final String sideways = green + "allowedSidewaysMove: " + isAllowedSidewaysMove() + nl;
        return name + initial + rowPos + colPos + backwards + diagonal + sideways;
    }

}
