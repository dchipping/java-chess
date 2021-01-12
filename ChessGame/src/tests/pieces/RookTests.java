package tests.pieces;

import main.board.Board;
import main.board.Move;
import main.pieces.PieceColour;
import main.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTests {

    @Test
    public void isValidMove_MoveSE_MoveRefuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveSE = new Move(2,2);

        board.getCell(4,4).setPiece(rook);

        assertFalse(rook.isValidMove(moveSE));
    }

    @Test
    public void isValidMove_MoveSW_MoveRefuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveSW = new Move(-2,2);

        board.getCell(4,4).setPiece(rook);

        assertFalse(rook.isValidMove(moveSW));
    }

    @Test
    public void isValidMove_MoveNE_MoveRefuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveNE = new Move(3,-3);

        board.getCell(4,4).setPiece(rook);

        assertFalse(rook.isValidMove(moveNE));
    }

    @Test
    public void isValidMove_MoveNW_MoveRefuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveNW = new Move(-3,-3);

        board.getCell(4,4).setPiece(rook);

        assertFalse(rook.isValidMove(moveNW));
    }

    @Test
    public void isValidMove_MoveRight_MoveExecuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveRight = new Move(3,0);

        board.getCell(4,4).setPiece(rook);

        assertTrue(rook.isValidMove(moveRight));
    }

    @Test
    public void isValidMove_MoveLeft_MoveExecuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveLeft = new Move(-4,0);

        board.getCell(4,4).setPiece(rook);

        assertTrue(rook.isValidMove(moveLeft));
    }

    @Test
    public void isValidMove_MoveUp_MoveExecuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveUp = new Move(0,-4);

        board.getCell(4,4).setPiece(rook);

        assertTrue(rook.isValidMove(moveUp));
    }

    @Test
    public void isValidMove_MoveDown_MoveExecuted() {
        Board board = new Board(8);
        Rook rook = new Rook(true, board.getCell(4,4));
        Move moveDown = new Move(0,3);

        board.getCell(4,4).setPiece(rook);

        assertTrue(rook.isValidMove(moveDown));
    }

    @Test
    public void isValidMove_MoveKnight_MoveRefuted() {
        Board board = new Board(8);
        Rook rook = new Rook(false, board.getCell(4,4));
        Move moveKnight = new Move(2,-1);

        board.getCell(4,4).setPiece(rook);

        assertFalse(rook.isValidMove(moveKnight));
    }
}
