package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> testAList = new AListNoResizing<>();
        BuggyAList<Integer> testBList = new BuggyAList<>();

        int[] itemsToAdd = new int[]{4, 5, 6};

        for(int i : itemsToAdd) {
            testAList.addLast(i);
            testBList.addLast(i);
        }
        assertEquals(testAList.size(), testBList.size());

        for(int n : itemsToAdd) {
            assertEquals(testAList.removeLast(), testBList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = B.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                if (L.size() == 0) {
                    continue;
                }
                L.getLast();
                B.getLast();
                System.out.println("getLast()");
            } else if (operationNumber == 3) {
                if (L.size() == 0) {
                    continue;
                }
                L.removeLast();
                B.removeLast();
                System.out.println("removeLast()");
            }
        }
    }
}
