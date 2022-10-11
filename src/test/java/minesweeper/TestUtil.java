package minesweeper;

public class TestUtil {

    public static int getCurrentMineCount(Minefield minefield) {
        return TestUtil.getCurrentTypeCount(minefield.getBoard(), Cell.Type.MINE);
    }

    public static int getCurrentClearCount(Minefield minefield) {
        return TestUtil.getCurrentTypeCount(minefield.getBoard(), Cell.Type.CLEAR);
    }

    private static int getCurrentTypeCount(Cell[][] board, Cell.Type type) {
        int count = 0;
        for (Cell [] cells: board) {
            for (Cell cell: cells) {
                if (cell.type == type) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Cell[][] generateBoard(int rows, int cols, String... boardValues) {
        if (boardValues.length != rows * cols) {
            return null;
        }

        Cell[][] board = new Cell[rows][cols];
        int r = 0;
        int c = 0;
        for(String boardValue: boardValues) {
            if (c == cols) {
                c = 0;
                r += 1;
            }
            if (boardValue.equals("X")) {
                board[r][c] = new Mine();
            }
            c += 1;
        }
        return  board;
    }
}
