package io.github.lukeeff.chess.chesspiece;

/**
 * The GCF's of chess pieces!
 */
abstract public class ChessPiece {

    private int rowPosition;
    private int columnPosition;
    public final boolean canJump;

    /**
     * Initializes a chess piece object.
     *
     * @param rowPosition the row position of the piece.
     * @param columnPosition the column position of the piece.
     * @param canJump does the piece jump over pieces.
     */
    public ChessPiece(int rowPosition, int columnPosition, boolean canJump) {
        this.canJump = canJump;
        this.columnPosition = columnPosition;
        this.rowPosition = rowPosition;
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
}
