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
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> brocken = new BuggyAList<>();
        correct.addLast(1);
        correct.addLast(2);
        correct.addLast(3);

        brocken.addLast(1);
        brocken.addLast(2);
        brocken.addLast(3);
        assertEquals(correct.size(),brocken.size());

        assertEquals(correct.removeLast(),brocken.removeLast());
        assertEquals(correct.removeLast(),brocken.removeLast());
        assertEquals(correct.removeLast(),brocken.removeLast());




    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggy.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0) {
                    int valL = L.getLast();
                    int valBuggy = buggy.getLast();
                    assertEquals(valL, valBuggy);
                    System.out.println("getLast: " + valL);
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() > 0) {
                    int removedL = L.removeLast();
                    int removedBuggy = buggy.removeLast();
                    assertEquals(removedL, removedBuggy);
                    System.out.println("removeLast: " + removedL);
                }
            }

        }
    }
}
