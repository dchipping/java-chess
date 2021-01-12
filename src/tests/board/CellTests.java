package tests.board;

import main.board.Board;
import main.pieces.Bishop;
import main.pieces.King;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTests {

    @Test
    public void isOccupiedByOpposition_EmptyCell_False() {
        Board board = new Board(8);
        King king = new King(true, board.getCell(2,4));
        board.getCell(2,4).setPiece(king);

        assertFalse(board.getCell(2,3).isOccupiedByOpposition(true));
    }

    @Test
    public void isOccupiedByOpposition_FriendlyPieceOnCell_False() {
        Board board = new Board(8);
        King king = new King(true, board.getCell(7,7));
        board.getCell(7,7).setPiece(king);

        assertFalse(board.getCell(7,7).isOccupiedByOpposition(true));
    }

    @Test
    public void isOccupiedByOpposition_EnemyPieceOnCell_True() {
        Board board = new Board(8);
        Bishop bishop = new Bishop(false, board.getCell(4,1));
        board.getCell(4,1).setPiece(bishop);

        assertTrue(board.getCell(4,1).isOccupiedByOpposition(true));
    }
}

