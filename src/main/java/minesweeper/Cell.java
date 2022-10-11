package minesweeper;

/** A base class that represents a singular cell in the minesweeper.minefield. */
public abstract class Cell {
    public enum Type {
        CLEAR,
        MINE
    }

    public enum Status {
        OPENED,
        UNOPENED
    }

    public boolean openCell() {
        if (this.status == Status.UNOPENED) {
            this.status = Status.OPENED;
        }
        return false;
    }

    public final Type type;
    private Status status;

    public Cell(Type type) {
        this.type = type;
        this.status = Status.UNOPENED;
    }

    public Status getStatus() {
        return this.status;
    }
}
