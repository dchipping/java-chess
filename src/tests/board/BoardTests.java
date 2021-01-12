package tests.board;

import static org.junit.jupiter.api.Assertions.*;
import main.board.Board;
import main.board.Cell;
import main.board.Move;
import main.pieces.Knight;
import main.pieces.Piece;
import main.pieces.PieceType;
import org.junit.jupiter.api.Test;

public class BoardTests {

    @Test
    public void createBoard_SingleCellBoard_Width1Height1() {
        Board board = new Board();

        board.createBoard(1);

        assertEquals(1, board.getWidth());
        assertEquals(1, board.getHeight());
    }

    @Test
    public void isMoveOnBoard_MovesOffBoardIdentified_MovesRefuted() {
        Board board = new Board(8);
        assertFalse(board.isMoveOnBoard(8, 8));
        assertFalse(board.isMoveOnBoard(-1, 8));
        assertFalse(board.isMoveOnBoard(-1, -1));
        assertFalse(board.isMoveOnBoard(8, 1));
    }

    @Test
    public void movePiece_PieceMoved_MovedCorrect() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(true, board.getCell(1,1), true);
        Move moveDown = new Move(0,1);
        board.getCell(1,1).setPiece(testPiece);

        board.movePiece(testPiece.getCell(), moveDown, testPiece);

        assertEquals(testPiece, board.getCell(1,2).getPiece());
        assertNull(board.getCell(1, 1).getPiece());
        assertEquals(1 ,testPiece.getCell().getX());
        assertEquals(2 ,testPiece.getCell().getY());
    }

    // Take enemy, piece is removed from board, attacking piece is in new position
    @Test
    public void movePiece_EnemyPieceAttacked_MovedCorrect() {
        Board board = new Board(8);
        TestPiece attacker = new TestPiece(true, board.getCell(4,4), true);
        TestPiece enemy = new TestPiece(false, board.getCell(7,7), true);
        board.getCell(4,4).setPiece(attacker);
        board.getCell(7,7).setPiece(enemy);

        Move moveSE = new Move(3,3);

        board.movePiece(attacker.getCell(), moveSE, attacker);

        assertEquals(attacker, board.getCell(7,7).getPiece());
        assertNull(board.getCell(4, 4).getPiece());
        assertEquals(7, attacker.getCell().getX());
        assertEquals(7, attacker.getCell().getY());

        assertNull(enemy.getCell());
    }

    @Test
    public void movePiece_PieceMovedOffBoard_MoveRefuted() {
        Board board = new Board(8);
        var testPiece = new TestPiece(false, board.getCell(1,1), true);
        Move moveUp = new Move(0,-2);
        board.getCell(1,1).setPiece(testPiece);

        board.movePiece(testPiece.getCell(), moveUp, testPiece);

        assertEquals(testPiece, board.getCell(1,1).getPiece());
    }

    @Test
    public void movePiece_InvalidMove_MoveRefuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(1,1), false);
        Move moveUp = new Move(0,-2);
        board.getCell(1,1).setPiece(testPiece);

        board.movePiece(testPiece.getCell(), moveUp, testPiece);

        assertEquals(testPiece, board.getCell(1,1).getPiece());
    }

    @Test
    public void isPathClear_MoveUpObstruction_MoveRefuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(true, board.getCell(4,4), true);
        TestPiece obstruction = new TestPiece(true, board.getCell(4,2), true);
        Move moveUp = new Move(0,-3);

        board.getCell(4,4).setPiece(testPiece);
        board.getCell(4,2).setPiece(obstruction);

        assertFalse(board.isPathClear(testPiece.getCell(), moveUp, testPiece));
    }

    @Test
    public void isPathClear_MoveUpNoObstruction_MoveExecuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(4,4), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(4,1), true);
        Move moveUp = new Move(0,-2);

        board.getCell(4,4).setPiece(testPiece);
        board.getCell(4,1).setPiece(obstruction);

        assertTrue(board.isPathClear(testPiece.getCell(), moveUp, testPiece));
    }

    @Test
    public void isPathClear_MoveLeftObstruction_MoveRefuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(4,4), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(3,4), true);
        Move moveLeft = new Move(-2,0);

        board.getCell(4,4).setPiece(testPiece);
        board.getCell(3,4).setPiece(obstruction);

        assertFalse(board.isPathClear(testPiece.getCell(), moveLeft, testPiece));
    }

    @Test
    public void isPathClear_MoveRightNoObstruction_MoveExecuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(4,4), true);
        TestPiece obstruction = new TestPiece(true, board.getCell(7,4), true);
        Move moveRight = new Move(2,0);

        board.getCell(4,4).setPiece(testPiece);
        board.getCell(7,4).setPiece(obstruction);

        assertTrue(board.isPathClear(testPiece.getCell(), moveRight, testPiece));
    }

    @Test
    public void isPathClear_MoveSEObstruction_MoveRefuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(4,4), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(5,5), true);
        Move moveSE = new Move(2,2);

        board.getCell(4,4).setPiece(testPiece);
        board.getCell(5,5).setPiece(obstruction);

        assertFalse(board.isPathClear(testPiece.getCell(), moveSE, testPiece));
    }

    @Test
    public void isPathClear_MoveNWNoObstruction_MoveExecuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(4,4), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(0,0), true);
        Move moveNW = new Move(-3,-3);

        board.getCell(4,4).setPiece(testPiece);
        board.getCell(3,4).setPiece(obstruction);

        assertTrue(board.isPathClear(testPiece.getCell(), moveNW, testPiece));
    }

    @Test
    public void isPathClear_MoveNEObstruction_MoveRefuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(3,3), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(5,1), true);
        Move moveNE = new Move(3,-3);

        board.getCell(3,3).setPiece(testPiece);
        board.getCell(5,1).setPiece(obstruction);

        assertFalse(board.isPathClear(testPiece.getCell(), moveNE, testPiece));
    }

    @Test
    public void isPathClear_MoveSWNoObstruction_MoveExecuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(true, board.getCell(3,3), true);
        TestPiece obstruction = new TestPiece(true, board.getCell(1,1), true);
        Move moveSW = new Move(-3,3);

        board.getCell(3,3).setPiece(testPiece);
        board.getCell(1,1).setPiece(obstruction);

        assertTrue(board.isPathClear(testPiece.getCell(), moveSW, testPiece));
    }

    @Test
    public void isPathClear_MoveLeftOntoEnemyPiece_MoveExecuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(true, board.getCell(3,3), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(6,3), true);
        Move moveRight = new Move(3,0);

        board.getCell(3,3).setPiece(testPiece);
        board.getCell(6,3).setPiece(obstruction);

        assertTrue(board.isPathClear(testPiece.getCell(), moveRight, testPiece));
    }

    @Test
    public void isPathClear_MoveLeftOntoAllyPiece_MoveRefuted() {
        Board board = new Board(8);
        TestPiece testPiece = new TestPiece(false, board.getCell(3,3), true);
        TestPiece obstruction = new TestPiece(false, board.getCell(6,3), true);
        Move moveRight = new Move(3,0);

        board.getCell(3,3).setPiece(testPiece);
        board.getCell(6,3).setPiece(obstruction);

        assertFalse(board.isPathClear(testPiece.getCell(), moveRight, testPiece));
    }

    @Test
    public void isPathClear_KnightMoves_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(6,1));
        Move moveDown = new Move(-2,1);

        board.getCell(6,1).setPiece(knight);

        assertTrue(board.isPathClear(knight.getCell(), moveDown, knight));
    }

    @Test
    public void isPathClear_KnightMovesOverPiece_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(false, board.getCell(3,3));
        TestPiece obstruction = new TestPiece(false, board.getCell(4,4), true);
        Move moveOverPiece = new Move(2,1);

        board.getCell(3,3).setPiece(knight);
        board.getCell(4,4).setPiece(obstruction);

        assertTrue(board.isPathClear(knight.getCell(), moveOverPiece, knight));
    }

    @Test
    public void isPathClear_KnightMovesOntoFriendlyPiece_MoveRefuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(0,0));
        TestPiece obstruction = new TestPiece(true, board.getCell(1,2), true);
        Move moveOntoFriendly = new Move(1,2);

        board.getCell(0,0).setPiece(knight);
        board.getCell(1,2).setPiece(obstruction);

        assertFalse(board.isPathClear(knight.getCell(), moveOntoFriendly, knight));
    }

    @Test
    public void isPathClear_KnightMovesOntoEnemyPiece_MoveExecuted() {
        Board board = new Board(8);
        Knight knight = new Knight(true, board.getCell(4,4));
        TestPiece obstruction = new TestPiece(false, board.getCell(2,3), true);
        Move moveOntoEnemy = new Move(-2,-1);

        board.getCell(4,4).setPiece(knight);
        board.getCell(2,3).setPiece(obstruction);

        assertTrue(board.isPathClear(knight.getCell(), moveOntoEnemy, knight));
    }

    private class TestPiece extends Piece {
        // Validity variable is used to easily test how a method handles isValidMove()
        Boolean validity;
        public TestPiece(boolean isWhite, Cell cell, Boolean validity) {
            super(isWhite, PieceType.TEST, cell);
            this.validity = validity;
        }

        @Override
        public boolean isValidMove(Move move) {
            return validity;
        }
    }
}