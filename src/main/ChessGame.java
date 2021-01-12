package main;

import main.board.Board;
import main.board.Cell;
import main.board.Move;
import main.pieces.King;

public class ChessGame {

    public static void main(String[] args) {
        Board chessBoard = new Board(8);
        King king = new King(true, null);
        //chessBoard.setPieceOnBoard(0,4, king);
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Cell cell = chessBoard.getCell(row, column);
                System.out.println("X Position: " + cell.getX() + ", Y Position: " + cell.getY() + ", Has Piece: " + cell.isOccupied());
            }
        }
        Cell cell1 = new Cell(0,4);
        Move move1 = new Move(1, 2);
        //chessBoard.movePieceOnBoard(0,4, move1);
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Cell cell = chessBoard.getCell(row, column);
                System.out.println("X Position: " + cell.getX() + ", Y Position: " + cell.getY() + ", Has Piece: " + cell.isOccupied());
            }
        }
    }
}
