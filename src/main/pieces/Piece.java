package main.pieces;

import main.board.Cell;
import main.board.Move;


public abstract class Piece {

    private boolean isWhite;
    private PieceType pieceType;
    private Cell cell;

    public Piece(boolean isWhite, PieceType pieceType, Cell cell) {
        this.isWhite = isWhite;
        this.pieceType = pieceType;
        this.cell = cell;
    }

    public abstract boolean isValidMove(Move move);

    public boolean canBeObstructed() {
        return true;
    }

    public PieceType getType() {
        return pieceType;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isBlack() {
        return !isWhite;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
}
