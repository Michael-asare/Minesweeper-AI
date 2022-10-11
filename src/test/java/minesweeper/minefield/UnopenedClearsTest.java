package minesweeper.minefield;

import minesweeper.Minefield;
import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class UnopenedClearsTest {

    @Test
    public void initial_unopened_clears_count_for_board_0x0_mines_0_expects_0() {
        int actual = createUnopenedClearsActual(0, 0, 0);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_1x0_mines_0_expects_0() {
        int actual = createUnopenedClearsActual(1, 0, 0);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_0x1_mines_0_expects_0() {
        int actual = createUnopenedClearsActual(0, 1, 0);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_1x1_mines_0_expects_1() {
        int actual = createUnopenedClearsActual(0, 1, 1);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_1x1_mines_1_expects_0() {
        int actual = createUnopenedClearsActual(0, 1, 1);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_5x5_mines_0_expects_25() {
        int actual = createUnopenedClearsActual(5, 5, 0);
        int expected = 25;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_5x5_mines_9_expects_16() {
        int actual = createUnopenedClearsActual(5, 5, 9);
        int expected = 16;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_3x7_mines_8_expects_13() {
        int actual = createUnopenedClearsActual(3, 7, 8);
        int expected = 13;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_11x4_mines_40_expects_4() {
        int actual = createUnopenedClearsActual(11, 4, 40);
        int expected = 4;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_10x10_mines_10_expects_90() {
        int actual = createUnopenedClearsActual(10, 10, 10);
        int expected = 90;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void initial_unopened_clears_count_for_board_100x1_mines_100_expects_0() {
        int actual = createUnopenedClearsActual(100, 1, 100);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    private int createUnopenedClearsActual(int rows, int cols, int mines) {
        Minefield minefield = new Minefield(rows, cols, mines);
        return minefield.getUnopenedClears();
    }
}
