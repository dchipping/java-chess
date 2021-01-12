package main.pieces;

import main.board.Cell;
import main.board.Move;

public class King extends Piece {

    public King(boolean isWhite, Cell cell) {
        super(isWhite, PieceType.KING, cell);
    }

    @Override
    public boolean isValidMove(Move move) {
        return Math.abs(move.getX()) <= 1 && Math.abs(move.getY()) <= 1;
    }
}
