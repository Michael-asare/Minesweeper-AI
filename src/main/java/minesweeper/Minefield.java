package minesweeper;

import java.util.ArrayList;
import java.util.stream.Collectors;

public final class Minefield {
    /** The number of rows in this map. */
    private final int rows;
    /** The number of columns in this map. */
    private final int cols;
    /** The number of mines in this map. */
    private final int mineCount;
    /** The number of clear squares opened */
    private int openedClears;
    /** The number of clear squares left to be opened */
    private int unopenedClears;
    /** The board of this map. */
    private final minesweeper.Cell[][] board;

    public Minefield(int rows, int cols, int mineCount) {
        this.rows = rows;
        this.cols = cols;
        this.mineCount = mineCount;
        /* Safe to assume that there are no opened clears at game start. */
        this.openedClears = 0;
        this.unopenedClears = initialUnopenedClearsCount();
        this.board = new Cell[this.rows][this.cols];
        initializeBoard();
    }

    // DO NOT CHANGE. FOR TESTING.
    public Minefield(int rows, int cols, int mineCount, Cell[][] board) {
        this.rows = rows;
        this.cols = cols;
        this.mineCount = mineCount;
        /* Safe to assume that there are no opened clears at game start. */
        this.openedClears = 0;
        this.unopenedClears = initialUnopenedClearsCount();
        this.board = board;
        initializeClears();
    }

    /**
     * @param r the row position of the cell to open
     * @param c the column position of the cell to open
     * @return true if the game is still playable, and false otherwise
     *  */
    public boolean openCell(int r, int c) {
        Cell cell = board[r][c];
        if (cell.openCell()) {
            int newlyOpenedClearCells = 1;
            if (cell.type == Cell.Type.CLEAR) {
                ArrayList<int []> cascadedCells = unopenedClearCellsToCascadeTo(r, c);
                newlyOpenedClearCells += cascadedCells.stream()
                        .map(position -> {
                    int row = position[0];
                    int col = position[1];
                    return board[row][col].openCell();
                })
                        .filter(cellWasOpened -> cellWasOpened)
                        .count();
                openedClears += newlyOpenedClearCells;
                unopenedClears -= newlyOpenedClearCells;
                // If there are no more unopened clears, we have officially won the game!
                return unopenedClears != 0;
                // If you did not hit a mine, the game is still playable, otherwise, you're out of luck!
            } else return cell.type != Cell.Type.MINE;
        }
        // The cell we clicked was already opened, so no change in the game state... aka true!
        return true;
    }

    public int getUnopenedClears() {
        return this.unopenedClears;
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    /**
     * Is the initial value of unopened clears.
     * For example, if the board is 10x10, and there are 10 mines, then there are 90 unopened clears at the start of
     * the game.
     *
     * @return the initial number of unopened clears
     * */
    private int initialUnopenedClearsCount() {
        // TODO: Implement this method
        return -999999999;
    }

    /**
     * Initializes the cells of the board.
     */
    private void initializeBoard() {
        initializeMines();
        initializeClears();
    }

    private void initializeMines() {
        for (int [] positions : randomNumbers(this.mineCount, this.rows * this.cols).stream()
                .filter(num -> num < this.rows * this.cols)
                .map(num -> new int[]{num / this.rows, num % this.cols})
                .collect(Collectors.toList())) {
            int row = positions[0];
            int col = positions[1];

            this.board[row][col] = new Mine();
        }
    }

    private void initializeClears() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (this.board[r][c] == null) {
                    this.board[r][c] = new Clear();
                }
            }
        }

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (this.board[r][c] instanceof Clear) {
                    long surroundingMines = adjacentCells(r, c).stream().filter(position -> {
                        int row = position[0];
                        int col = position[1];
                        return this.board[row][col] instanceof Mine;
                    }).count();
                    ((Clear) (this.board[r][c])).setSurrondingMines((int) surroundingMines);
                }
            }
        }
    }

    /**
     * Used to place mines on board randomly. Generates N distinctNumbers from [0, upperBound)
     * @param distinctNumbers the number of distinct numbers to generate.
     * @param upperBound the upper (exclusive) number that can possibly be generated.
     * @return a list of random integers of size distinctNumbers, capped up to (but not including) upperBound
     * */
    private ArrayList<Integer> randomNumbers(int distinctNumbers, int upperBound) {
        // TODO: Implement this method
        return new ArrayList<>();
    }

    /**
     * Gets all the possible positions of the cells adjacent or diagonal.
     *
     * @param r the row position of the cell
     * @param c the column position of the cell
     * @return returns a list of [r, c] where [r, c] is the position of the cell adjacent or diagonal
     */
    private ArrayList<int []> adjacentCells(int r, int c) {
        // TODO: Implement this method
        return new ArrayList<>();
    }

    /**
     * @param r the row position of the cell
     * @param c the column position of the cell
     * @return returns a list of [r, c] where [r, c] is the position of the cells that should be opened automatically
     * by the computer. To be automatically opened by the computer, the cells must be:
     * 1) CLEAR
     * 2) UNOPENED
     * 3) Have a path that leads to the original cell
     * Remember.. you can no longer cascade after hitting a clear cell with a non-zero amount of mines adjacent to it
     */
    private ArrayList<int []> unopenedClearCellsToCascadeTo(int r, int c) {
        // TODO: Implement this method
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < this.rows; r++) {
            for(int c = 0; c < this.cols; c++) {
                Cell cell = this.board[r][c];
                if (cell.getStatus() == Cell.Status.UNOPENED) {
                    sb.append(" - ");
                } else {
                    if (cell.type == Cell.Type.MINE) {
                        sb.append(" X ");
                    } else {
                        Clear castedCell = (Clear) cell;
                        sb.append(" ").append(castedCell.getSurroundingMines()).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
