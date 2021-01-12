package tests;
import main.board.*;
import main.pieces.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    @Test
    public void test() {
        // > New ChessGameTest, run a small game of chess
        assertEquals(1, 1);
    }

    @Test
    public void MiniChessGame_3White4Black_FinalPositionsCorrect() {
        Board board = new Board(8);

        var whitePawn = new Pawn(true, board.getCell(1,1), board); // White Pawn, x:1 y:1
        board.getCell(1,1).setPiece(whitePawn);
        var whiteQueen = new Queen(true, board.getCell(1,0)); // White Queen, x:1 y:0
        board.getCell(1,0).setPiece(whiteQueen);
        var whiteRook = new Rook(true, board.getCell(0,0)); // White Rook, x:0, y:0
        board.getCell(0,0).setPiece(whiteRook);

        var blackPawn = new Pawn(false, board.getCell(2,3), board); // Black Pawn, x:2, y:3
        board.getCell(2,3).setPiece(blackPawn);
        var blackKnight = new Knight(false,board.getCell(2,4)); // Black Knight, x:2, y:4
        board.getCell(2,4).setPiece(blackKnight);
        var blackBishop = new Bishop(false,board.getCell(3,3)); // Black Bishop, x:0, y:0
        board.getCell(0,0).setPiece(blackBishop);
        var blackKing = new King(false, board.getCell(3,4)); // Black King, x:3, y:4
        board.getCell(3,4).setPiece(blackKing);


        var whitePawn_moveForwardOne = new Move(0,1); // Move whitePawn to x:1, y:2
        var blackKnight_attackNNW = new Move(-1,-2); // blackKnight attacks whitePawn at x:1, y:2
        var whiteQueen_attackForward = new Move(0,2); // whiteQueen attacks blackKnight at x:1, y:2
        var blackBishop_attackNW = new Move(-3,-3); // blackBishop attacks whiteRook at x:0, y:0
        var whiteQueen_attackSE = new Move(1,1); // whiteQueen attacks blackPawn at x:2, y:2
        var blackKing_attackNW = new Move(-1, -1); // blackKing attacks whiteQueen at x:2, y:2

        board.movePiece(board.getCell(1,1), whitePawn_moveForwardOne, whitePawn);
        board.movePiece(board.getCell(2,4), blackKnight_attackNNW, blackKnight);
        board.movePiece(board.getCell(1,0), whiteQueen_attackForward, whiteQueen);
        board.movePiece(board.getCell(3,3), blackBishop_attackNW, blackBishop);
        board.movePiece(board.getCell(1,2), whiteQueen_attackSE, whiteQueen);
        board.movePiece(board.getCell(3,4), blackKing_attackNW, blackKing);

        assertEquals(blackBishop, board.getCell(0,0).getPiece());
        assertNull(board.getCell(1,0).getPiece());
        assertNull(board.getCell(1,1).getPiece());
        assertNull(board.getCell(1,2).getPiece());
        assertEquals(blackKing, board.getCell(2,3).getPiece());
        assertNull(board.getCell(3,3).getPiece());
        assertNull(board.getCell(2,4).getPiece());
        assertNull(board.getCell(3,4).getPiece());
    }
}