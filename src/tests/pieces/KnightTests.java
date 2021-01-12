package tests.pieces;

import main.board.Board;
import main.board.Move;
import main.pieces.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTests {

    @Test
    public void isValidMove_MoveESE_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveESE = new Move(2,1);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveESE));
    }

    @Test
    public void isValidMove_MoveSSE_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveSSE = new Move(1,2);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveSSE));
    }

    @Test
    public void isValidMove_MoveNNE_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveNNE = new Move(1,-2);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveNNE));
    }

    @Test
    public void isValidMove_MoveENE_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveENE = new Move(2,-1);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveENE));
    }

    @Test
    public void isValidMove_MoveNNW_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveNNW = new Move(-1,-2);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveNNW));
    }

    @Test
    public void isValidMove_MoveWNW_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveWNW = new Move(-2,-1);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveWNW));
    }

    @Test
    public void isValidMove_MoveWSW_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveWNW = new Move(-2,1);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveWNW));
    }

    @Test
    public void isValidMove_MoveSSW_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveSSW = new Move(-1,2);

        board.getCell(4,4).setPiece(knight);

        assertTrue(knight.isValidMove(moveSSW));
    }

    @Test
    public void isValidMove_MoveSE_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveSE = new Move(2,2);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveSE));
    }

    @Test
    public void isValidMove_MoveSW_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveSW = new Move(-2,2);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveSW));
    }

    @Test
    public void isValidMove_MoveNE_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(false, board.getCell(4,4));
        Move moveNE = new Move(3,-3);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveNE));
    }

    @Test
    public void isValidMove_MoveNW_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveNW = new Move(-3,-3);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveNW));
    }

    @Test
    public void isValidMove_MoveRight_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveRight = new Move(3,0);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveRight));
    }

    @Test
    public void isValidMove_MoveLeft_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(false, board.getCell(4,4));
        Move moveLeft = new Move(-4,0);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveLeft));
    }

    @Test
    public void isValidMove_MoveUp_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveUp = new Move(0,-4);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveUp));
    }

    @Test
    public void isValidMove_MoveDown_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        Move moveDown = new Move(0,3);

        board.getCell(4,4).setPiece(knight);

        assertFalse(knight.isValidMove(moveDown));
    }
}
