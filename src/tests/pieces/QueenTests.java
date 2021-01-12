package tests.pieces;

import main.board.Board;
import main.board.Move;

import main.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTests {

    @Test
    public void isValidMove_MoveUp_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveUp = new Move (0,-4);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveUp));
    }

    @Test
    public void isValidMove_MoveDown_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveDown = new Move (0,3);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveDown));
    }

    @Test
    public void isValidMove_MoveLeft_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveLeft = new Move (-1,0);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveLeft));
    }

    @Test
    public void isValidMove_MoveRight_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveRight = new Move (3,0);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveRight));
    }

    @Test
    public void isValidMove_MoveNE_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveNE = new Move(3, -3);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveNE));
    }

    @Test
    public void isValidMove_MoveSE_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveSE = new Move(2, 2);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveSE));
    }

    @Test
    public void isValidMove_MoveSW_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveSW = new Move(-3, 3);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveSW));
    }

    @Test
    public void isValidMove_MoveNW_MoveExecuted() {
        Board board = new Board(8);
        Queen queen = new Queen(true, board.getCell(4,4));
        Move moveNW = new Move(-2, -2);

        board.getCell(4,4).setPiece(queen);

        assertTrue(queen.isValidMove(moveNW));
    }

    @Test
    public void isValidMove_MoveKnightSE_MoveRefuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveKnightSE = new Move(2,1);

        board.getCell(4,4).setPiece(queen);

        assertFalse(queen.isValidMove(moveKnightSE));
    }

    @Test
    public void isValidMove_MoveKnightNW_MoveRefuted() {
        Board board = new Board(8);
        Queen queen = new Queen(false, board.getCell(4,4));
        Move moveKnightNW = new Move(-1,-2);

        board.getCell(4,4).setPiece(queen);

        assertFalse(queen.isValidMove(moveKnightNW));
    }

//    @Test
//    public void isValidMove_MoveOffBoard_MoveRefuted() {
//        Board board = new Board(8);
//        Queen queen = new Queen(false, board.getCell(4,4));
//        Move moveOffBoard = new Move(4,4);
//
//        board.getCell(4,4).setPiece(queen);
//
//        assertFalse(queen.isValidMove(moveOffBoard, board));
//    }
}