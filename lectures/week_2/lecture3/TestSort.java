package lecture3;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"they", "changed", "the", "system"};
        String[] expected = {"changed", "system", "the", "they"};
        Sort.sort(input);
        assertArrayEquals(expected, input );
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"they", "changed", "the", "system"};
        int expected = 1;

        int actual = Sort.findSmallest(input, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void testSwap() {
        String[] input = {"they", "changed", "the", "system"};
        String[] expected = {"they", "system", "the", "changed"};


        Sort.swap(input, 1, 3);
        assertArrayEquals(expected, input);
    }
}