package main.pieces;

import main.board.Cell;
import main.board.Move;

public class Knight extends Piece {

    public Knight(boolean isWhite, Cell cell) {
        super(isWhite, PieceType.KNIGHT, cell);
    }

    @Override
    public boolean isValidMove(Move move) {
        int dX = move.getX();
        int dY = move.getY();

        return Math.sqrt(dX * dX + dY * dY) == Math.sqrt(5);
    }

    @Override
    public boolean canBeObstructed() {
        return false;
    }
}