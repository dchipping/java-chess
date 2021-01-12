package main.pieces;

import main.board.Cell;
import main.board.Move;

public class Queen extends Piece {

    public Queen(boolean isWhite, Cell cell) {
        super(isWhite, PieceType.QUEEN, cell);
    }

    @Override
    public boolean isValidMove(Move move) {
        return (move.getX() * move.getY() == 0) != (Math.abs(move.getX()) == Math.abs(move.getY()));
    }
}
