package main.pieces;

import main.board.Board;
import main.board.Cell;
import main.board.Move;

public class Pawn extends Piece {

    private Board board;

    public Pawn(boolean isWhite, Cell cell, Board board) {
        super(isWhite, PieceType.PAWN, cell);
        this.board = board;
    }

    @Override
    public boolean isValidMove(Move move) {
        return (move.getX() == 0 && (isForward(move, 1) || isValidTwoMove(move, this.board.getHeight())))
                || isPawnAttack(move);
    }

    private boolean isForward(Move move, int limit) {
        return (this.isWhite() && move.getY() == limit)
                || (this.isBlack() && move.getY() == -limit);
    }

    private boolean isValidTwoMove(Move move, int boardHeight) {
        return isForward(move, 2)
                && ((this.isWhite() && getCell().getY() == 1)
                || (this.isBlack() && getCell().getY() == boardHeight - 2));
    }

    private boolean isPawnAttack(Move move) {
        int newX = this.getCell().getX() + move.getX();
        int newY = this.getCell().getY() + move.getY();
        return this.board.getCell(newX, newY).isOccupiedByOpposition(this.isWhite())
                && (Math.abs(move.getX()) == 1 && ((this.isWhite() && move.getY() == 1)
                || (this.isBlack() && move.getY() == -1)));
    }

}