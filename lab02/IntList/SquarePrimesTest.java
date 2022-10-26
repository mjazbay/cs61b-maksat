package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesComplex() {
        IntList lst = IntList.of(17, 15, 17, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("289 -> 15 -> 289 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesLastElement() {
        IntList lst = IntList.of(16, 15, 15, 15, 17);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("16 -> 15 -> 15 -> 15 -> 289", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesNoChange() {
        IntList lst = IntList.of(16, 15, 15, 15, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("16 -> 15 -> 15 -> 15 -> 18", lst.toString());
        assertFalse(changed);
    }
}
