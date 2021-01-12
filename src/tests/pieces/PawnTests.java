package tests.pieces;

import main.board.Board;
import main.board.Move;
import main.pieces.Pawn;
import main.pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {

    @Test
    public void isValidMove_x1y1WhiteForwardBy2_MoveExecuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(1,1), board);
        Move downTwo = new Move(0,2);

        board.getCell(1,1).setPiece(pawn);

        assertTrue(pawn.isValidMove(downTwo));
    }

    @Test
    public void isValidMove_x1y1BlackForwardBy2_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(1,1), board);
        Move downTwo = new Move(0,2);

        board.getCell(1,1).setPiece(pawn);

        assertFalse(pawn.isValidMove(downTwo));
    }

    @Test
    public void isValidMove_x1y1WhiteForwardBy1_MoveExecuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(1,1), board);
        Move downOne = new Move(0,1);

        board.getCell(1,1).setPiece(pawn);

        assertTrue(pawn.isValidMove(downOne));
    }

    @Test
    public void isValidMove_x1y6WhiteForwardBy2_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(1,6), board);
        Move upTwo = new Move(0,-2);

        board.getCell(1,6).setPiece(pawn);

        assertFalse(pawn.isValidMove(upTwo));
    }

    @Test
    public void isValidMove_x1y6BlackForwardBy2_MoveExecuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(1,6), board);
        Move upTwo = new Move(0,-2);

        board.getCell(1,6).setPiece(pawn);

        assertTrue(pawn.isValidMove(upTwo));
    }

    @Test
    public void isValidMove_x1y6BlackForwardBy1_MoveExecuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(1,6), board);
        Move upOne = new Move(0,-1);

        board.getCell(1,6).setPiece(pawn);

        assertTrue(pawn.isValidMove(upOne));
    }

    @Test
    public void isValidMove_x1y6WhiteForwardx2y1_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(1,6), board);
        Move downRight = new Move(2,1);

        board.getCell(1,6).setPiece(pawn);

        assertFalse(pawn.isValidMove(downRight));
    }

    @Test
    public void isValidMove_x1y6BlackForwardx2y1_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(1,6), board);
        Move upRight = new Move(2,-1);

        board.getCell(1,6).setPiece(pawn);

        assertFalse(pawn.isValidMove(upRight));
    }

    @Test
    public void isValidMove_MoveRight_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(1,6), board);
        Move moveRight = new Move(1,0);

        board.getCell(1,6).setPiece(pawn);

        assertFalse(pawn.isValidMove(moveRight));
    }

    @Test
    public void isValidMove_MoveLeft_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(1,6), board);
        Move moveLeft = new Move(-1,0);

        board.getCell(1,6).setPiece(pawn);

        assertFalse(pawn.isValidMove(moveLeft));
    }

    @Test
    public void isValidMove_WhiteAttackDiagonalBlack_MoveExecuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(2,3), board);
        Piece enemyPawn = new Pawn(false, board.getCell(1,4), board);
        Move moveSW = new Move(-1,1);

        board.getCell(2,3).setPiece(pawn);
        board.getCell(1,4).setPiece(enemyPawn);

        assertTrue(pawn.isValidMove(moveSW));
    }

    @Test
    public void isValidMove_BlackAttackDiagonalWhite_MoveExecuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(5,5), board);
        Piece enemyPawn = new Pawn(true, board.getCell(4,4), board);
        Move moveNW = new Move(-1,-1);

        board.getCell(5,5).setPiece(pawn);
        board.getCell(4,4).setPiece(enemyPawn);

        assertTrue(pawn.isValidMove(moveNW));
    }

    @Test
    public void isValidMove_WhiteAttacksDiagonalBlackBackwards_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(4,4), board);
        Piece enemyPawn = new Pawn(false, board.getCell(5,3), board);
        Move moveNE = new Move(1,-1);

        board.getCell(4,4).setPiece(pawn);
        board.getCell(5,3).setPiece(enemyPawn);

        assertFalse(pawn.isValidMove(moveNE));
    }

    @Test
    public void isValidMove_BlackAttacksDiagonalWhiteBackwards_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(false, board.getCell(2,5), board);
        Piece enemyPawn = new Pawn(true, board.getCell(3,6), board);
        Move moveSE = new Move(1,1);

        board.getCell(2,5).setPiece(pawn);
        board.getCell(3,6).setPiece(enemyPawn);

        assertFalse(pawn.isValidMove(moveSE));
    }

    @Test
    public void isValidMove_MoveDiagonal_MoveRefuted() {
        Board board = new Board(8);
        Piece pawn = new Pawn(true, board.getCell(2,5), board);
        Move moveNE = new Move(1,-1);

        board.getCell(2,5).setPiece(pawn);

        assertFalse(pawn.isValidMove(moveNE));
    }
}
