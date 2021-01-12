package main.board;

import main.pieces.Piece;

public class Board {

    private Cell[][] cells;

    public Board() {
    }

    public Board(int rowLength) {
        createBoard(rowLength);
    }

    public void createBoard(int rowLength) {
        cells = new Cell[rowLength][rowLength];

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < rowLength; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

    public void movePiece(Cell currentCell, Move move, Piece piece) {
        int destX = currentCell.getX() + move.getX();
        int destY = currentCell.getY() + move.getY();

        // Check move is on board, the move is legal and the path has no obstructions
        if (isMoveOnBoard(destX, destY) && piece.isValidMove(move) && isPathClear(currentCell, move, piece)) {
            Cell destCell = getCell(destX, destY);

            if (destCell.isOccupiedByOpposition(piece.isWhite())) {
                System.out.println("Attacked");
                destCell.removePiece();
            }

            // Update board on piece's new cell
            currentCell.removePiece();
            destCell.setPiece(piece);
        }
        else {
            System.out.println("Invalid move!");
        }
    }
    // > New ChessGameTest, run a small game of chess
    public boolean isMoveOnBoard(int newX, int newY) {
        return 0 <= newX && newX < this.getHeight() && 0 <= newY && newY < this.getHeight();
    }

    public boolean isPathClear(Cell currentCell, Move move, Piece piece) {
        Cell destCell = getCell(currentCell.getX() + move.getX(), currentCell.getY() + move.getY());
        currentCell = piece.canBeObstructed() ? getNextCell(currentCell, move) : destCell;

        while (!isDestinationCell(currentCell, destCell) && !currentCell.isOccupied()) {
            currentCell = getNextCell(currentCell, move);
        }

        return isDestinationCell(currentCell, destCell)
                && (!currentCell.isOccupied() || currentCell.isOccupiedByOpposition(piece.isWhite()));
    }

    private Cell getNextCell(Cell currentCell, Move move) {
        return getCell(currentCell.getX() + findCounter(move.getX()), currentCell.getY() + findCounter(move.getY()));
    }

    private int findCounter(int coordinate) {
        return coordinate == 0 ? 0 : coordinate/Math.abs(coordinate);
    }

    private boolean isDestinationCell(Cell currentCell, Cell destCell) {
        return destCell.getX() == currentCell.getX() && destCell.getY() == currentCell.getY();
    }
}

// DeMorgan's Law