package tests.pieces;

import main.board.Board;
import main.board.Move;
import main.pieces.King;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTests {

    @Test
    public void isValidMove_MoveDiagByTwo_False() {
        Board board = new Board(8);
        King king = new King(true, board.getCell(2,4));
        Move moveDiagByTwo = new Move(2,2);

        board.getCell(2,4).setPiece(king);

        assertFalse(king.isValidMove(moveDiagByTwo));
    }

    @Test
    public void isValidMove_MoveDiagByOne_True() {
        Board board = new Board(8);
        King king = new King(true, board.getCell(2,4));
        Move moveDiag = new Move(1,1);

        board.getCell(2,4).setPiece(king);

        assertTrue(king.isValidMove(moveDiag));
    }

    @Test
    public void isValidMove_MoveDiagByTwoReverse_False() {
        Board board = new Board(8);
        King king = new King(true, board.getCell(2,4));
        Move moveDiagByTwo = new Move(-2,-2);

        board.getCell(2,4).setPiece(king);

        assertFalse(king.isValidMove(moveDiagByTwo));
    }

    @Test
    public void isValidMove_MoveDiagByOneReverse_True() {
        Board board = new Board(8);
        King king = new King(true, board.getCell(2,4));
        Move moveDiag = new Move(-1,-1);

        board.getCell(2,4).setPiece(king);

        assertTrue(king.isValidMove(moveDiag));
    }
}
