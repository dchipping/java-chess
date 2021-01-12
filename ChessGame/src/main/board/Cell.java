package main.board;

import main.pieces.Piece;

public class Cell {

    private int x;
    private int y;
    private Piece piece;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        piece = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        piece.setCell(this);
        this.piece = piece;
    }

    public void removePiece() {
        piece.setCell(null);
        this.piece = null;

    }

    public boolean isOccupied() {
        return piece != null;
    }

    public boolean isOccupiedByOpposition(boolean isWhitePiece) {
        return isOccupied() && piece.isWhite() != isWhitePiece;
    }
}
