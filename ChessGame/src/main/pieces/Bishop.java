package main.pieces;

import main.board.Cell;
import main.board.Move;

public class Bishop extends Piece {

    public Bishop(boolean isWhite, Cell cell) {
        super(isWhite, PieceType.KING, cell);
    }

    @Override
    public boolean isValidMove(Move move) {
        return Math.abs(move.getX()) == Math.abs(move.getY());
    }
}
