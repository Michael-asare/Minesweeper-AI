package minesweeper.minefield;

import minesweeper.Minefield;
import minesweeper.TestUtil;
import org.junit.Test;
import static com.google.common.truth.Truth.*;


public class RandomNumbersTest {

    @Test
    public void random_numbers_for_board_0x0_mines_0_expects_0_clear_cells() {
        Minefield minefield = new Minefield(0, 0, 0);
        int actual = TestUtil.getCurrentClearCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_0x0_mines_0_expects_0_mine_cells() {
        Minefield minefield = new Minefield(0, 0, 0);
        int actual = TestUtil.getCurrentMineCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_1x0_mines_0_expects_0_clear_cells() {
        Minefield minefield = new Minefield(1, 0, 0);
        int actual = TestUtil.getCurrentClearCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_1x0_mines_0_expects_0_mine_cells() {
        Minefield minefield = new Minefield(1, 0, 0);
        int actual = TestUtil.getCurrentMineCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_0x1_mines_0_expects_0_clear_cells() {
        Minefield minefield = new Minefield(0, 1, 0);
        int actual = TestUtil.getCurrentClearCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_0x1_mines_0_expects_0_mine_cells() {
        Minefield minefield = new Minefield(0, 1, 0);
        int actual = TestUtil.getCurrentMineCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_5x3_mines_0_expects_15_clear_cells() {
        Minefield minefield = new Minefield(5, 3, 0);
        int actual = TestUtil.getCurrentClearCount(minefield);
        int expected = 15;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_5x3_mines_0_expects_0_mine_cells() {
        Minefield minefield = new Minefield(5, 3, 0);
        int actual = TestUtil.getCurrentMineCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_5x3_mines_10_expects_5_clear_cells() {
        Minefield minefield = new Minefield(5, 3, 10);
        int actual = TestUtil.getCurrentClearCount(minefield);
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_5x3_mines_10_expects_5_mine_cells() {
        Minefield minefield = new Minefield(5, 3, 10);
        int actual = TestUtil.getCurrentMineCount(minefield);
        int expected = 10;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_6x7_mines_42_expects_0_clear_cells() {
        Minefield minefield = new Minefield(6, 7, 42);
        int actual = TestUtil.getCurrentClearCount(minefield);
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void random_numbers_for_board_6x7_mines_42_expects_42_mine_cells() {
        Minefield minefield = new Minefield(6, 7, 42);
        int actual = TestUtil.getCurrentMineCount(minefield);
        int expected = 42;
        assertThat(actual).isEqualTo(expected);
    }
}
