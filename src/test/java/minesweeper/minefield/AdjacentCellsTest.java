package minesweeper.minefield;

import minesweeper.*;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;


public class AdjacentCellsTest {

    @Test
    public void adjacent_cells_for_board_3x3_with_0_mines() {
        Cell[][] board = TestUtil.generateBoard(3, 3,
                "", "", "",
                "", "", "",
                "", "", "");
        Minefield minefield = new Minefield(3, 3, 1, board);
        int actual_0_0 = ((Clear) board[0][0]).getSurroundingMines();
        int actual_0_1 = ((Clear) board[0][1]).getSurroundingMines();
        int actual_0_2 = ((Clear) board[0][2]).getSurroundingMines();
        int actual_1_0 = ((Clear) board[1][0]).getSurroundingMines();
        int actual_1_1 = ((Clear) board[1][1]).getSurroundingMines();
        int actual_1_2 = ((Clear) board[1][2]).getSurroundingMines();
        int actual_2_0 = ((Clear) board[2][0]).getSurroundingMines();
        int actual_2_1 = ((Clear) board[2][1]).getSurroundingMines();
        int actual_2_2 = ((Clear) board[2][2]).getSurroundingMines();

        int expectedAll = 0;
        assertThat(Arrays.stream(new int[]{
                actual_0_0,
                actual_0_1,
                actual_0_2,
                actual_1_0,
                actual_1_1,
                actual_1_2,
                actual_2_0,
                actual_2_1,
                actual_2_2}).allMatch(actual -> actual == expectedAll)).isTrue();
    }

    @Test
    public void adjacent_cells_for_board_3x3_with_1_mine() {
        Cell[][] board = TestUtil.generateBoard(3, 3,
                "", "", "",
                "", "X", "",
                "", "", "");
        Minefield minefield = new Minefield(3, 3, 1, board);
        int actual_0_0 = ((Clear) board[0][0]).getSurroundingMines();
        int actual_0_1 = ((Clear) board[0][1]).getSurroundingMines();
        int actual_0_2 = ((Clear) board[0][2]).getSurroundingMines();
        int actual_1_0 = ((Clear) board[1][0]).getSurroundingMines();
        int actual_1_2 = ((Clear) board[1][2]).getSurroundingMines();
        int actual_2_0 = ((Clear) board[2][0]).getSurroundingMines();
        int actual_2_1 = ((Clear) board[2][1]).getSurroundingMines();
        int actual_2_2 = ((Clear) board[2][2]).getSurroundingMines();

        int expectedAll = 1;
        assertThat(Arrays.stream(new int[]{
                actual_0_0,
                actual_0_1,
                actual_0_2,
                actual_1_0,
                actual_1_2,
                actual_2_0,
                actual_2_1,
                actual_2_2}).allMatch(actual -> actual == expectedAll)).isTrue();
    }

    @Test
    public void adjacent_cells_for_board_3x3_with_2_mines() {
        Cell[][] board = TestUtil.generateBoard(3, 3,
                "", "", "X",
                "", "", "",
                "X", "", "");
        Minefield minefield = new Minefield(3, 3, 2, board);
        int actual_0_0 = ((Clear) board[0][0]).getSurroundingMines();
        int actual_0_1 = ((Clear) board[0][1]).getSurroundingMines();
        int actual_1_0 = ((Clear) board[1][0]).getSurroundingMines();
        int actual_1_1 = ((Clear) board[1][1]).getSurroundingMines();
        int actual_1_2 = ((Clear) board[1][2]).getSurroundingMines();
        int actual_2_1 = ((Clear) board[2][1]).getSurroundingMines();
        int actual_2_2 = ((Clear) board[2][2]).getSurroundingMines();

        int expectedCorners = 0;
        assertThat(Arrays.stream(new int[]{
                actual_0_0,
                actual_2_2}).allMatch(actual -> actual == expectedCorners)).isTrue();

        int expectedNonCenter = 1;
        assertThat(Arrays.stream(new int[]{
                actual_0_1,
                actual_1_0,
                actual_1_2,
                actual_2_1}).allMatch(actual -> actual == expectedNonCenter)).isTrue();

        int expectedCenter = 2;
        assertThat(actual_1_1).isEqualTo(expectedCenter);
    }
}
