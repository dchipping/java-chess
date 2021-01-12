package main.pieces;

import main.board.Cell;
import main.board.Move;

public class Rook extends Piece {

    public Rook(boolean isWhite, Cell cell) {
        super(isWhite, PieceType.ROOK, cell);
    }

    @Override
    public boolean isValidMove(Move move) {
        return move.getX() * move.getY() == 0;
    }
}
