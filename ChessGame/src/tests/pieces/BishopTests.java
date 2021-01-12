package tests.pieces;

import main.board.Board;
import main.board.Move;
import main.pieces.Bishop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTests {

    @Test
    public void isValidMove_MoveRight_MoveRefuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(true, board.getCell(4,4));
        Move moveRight = new Move(2,0);

        board.getCell(4,4).setPiece(bishop);

        assertFalse(bishop.isValidMove(moveRight));
    }

    @Test
    public void isValidMove_MoveLeft_MoveRefuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(true, board.getCell(4,4));
        Move moveLeft = new Move(-2,0);

        board.getCell(4,4).setPiece(bishop);

        assertFalse(bishop.isValidMove(moveLeft));
    }

    @Test
    public void isValidMove_MoveNE_MoveExecuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(true, board.getCell(4,4));
        Move moveNE = new Move(2,-2);

        board.getCell(4,4).setPiece(bishop);

        assertTrue(bishop.isValidMove(moveNE));
    }

    @Test
    public void isValidMove_MoveSW_MoveExecuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(true, board.getCell(4,4));
        Move moveSW = new Move(-2,2);

        board.getCell(4,4).setPiece(bishop);

        assertTrue(bishop.isValidMove(moveSW));
    }

    @Test
    public void isValidMove_MoveSE_MoveExecuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(false, board.getCell(4,4));
        Move moveSE = new Move(2,2);

        board.getCell(4,4).setPiece(bishop);

        assertTrue(bishop.isValidMove(moveSE));
    }

    @Test
    public void isValidMove_MoveNW_MoveExecuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(true, board.getCell(4,4));
        Move moveNW = new Move(-2,-2);

        board.getCell(4,4).setPiece(bishop);

        assertTrue(bishop.isValidMove(moveNW));
    }

//    @Test
//    public void isValidMove_MoveOffBoard_MoveExecuted() {
//        Board board = new Board(8);
//        Bishop bishop = new Bishop(false, board.getCell(4,4));
//        Move moveOffBoard = new Move(8,8);
//
//        board.getCell(4,4).setPiece(bishop);
//
//        assertFalse(bishop.isValidMove(moveOffBoard, board));
//    }

    @Test
    public void isValidMove_MoveKnight_MoveExecuted() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(false, board.getCell(4,4));
        Move moveKnight = new Move(2,1);

        board.getCell(4,4).setPiece(bishop);

        assertFalse(bishop.isValidMove(moveKnight));
    }
}
