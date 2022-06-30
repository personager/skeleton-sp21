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
    public void myTest1() {
        IntList lst = IntList.of(7, 0, -2, 7, -7, 1, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("49 -> 0 -> -2 -> 49 -> -7 -> 1 -> 49", lst.toString());
        assertTrue(changed);
    }
}
