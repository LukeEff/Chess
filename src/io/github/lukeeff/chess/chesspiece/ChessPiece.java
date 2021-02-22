package io.github.lukeeff.chess.chesspiece;

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


    /**
     * Initializes a chess piece object.
     * @param rowPosition the row position of the piece.
     * @param columnPosition the column position of the piece.
     * @param jumper does the piece jump over pieces.
     * @param allowedBackwardsMove is piece allowed to move backwards.
     * @param allowedDiagonalMove is piece allowed to move diagonal.
     * @param allowedSidewaysMove is piece allowed to move sideways.
     */
    public ChessPiece(int rowPosition, int columnPosition, boolean jumper, boolean allowedBackwardsMove, boolean allowedDiagonalMove, boolean allowedSidewaysMove) {
        this.jumper = jumper;
        this.columnPosition = columnPosition;
        this.rowPosition = rowPosition;
        this.allowedBackwardsMove = allowedBackwardsMove;
        this.allowedDiagonalMove = allowedDiagonalMove;
        this.allowedSidewaysMove = allowedSidewaysMove;
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
}
