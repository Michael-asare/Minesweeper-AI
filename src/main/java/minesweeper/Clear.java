package minesweeper;

public class Clear extends Cell {
    private int surroundingMines;

    public Clear() {
        super(Type.CLEAR);
    }

    public void setSurrondingMines(int surroundingMines) {
        this.surroundingMines = surroundingMines;
    }

    public int getSurroundingMines() {
        return this.surroundingMines;
    }
}
