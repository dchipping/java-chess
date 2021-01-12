package main.board;

public class Move {

    int dX;
    int dY;

    public Move(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    public int getX() {
        return dX;
    }

    public int getY() {
        return dY;
    }

}
