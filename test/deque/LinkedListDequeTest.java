package deque;

import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void aDequeWith3ItemsShouldHaveSize3() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void aDequeShouldBeEmptyAfterAddingAndRemovingAnItem() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void removingEmptyDequeResultsARuntimeException() {
        LinkedListDeque<Integer> int_deque = new LinkedListDeque<Integer>();

        assertThrows(RuntimeException.class, () -> {
            int_deque.removeFirst();
        });
        assertThrows(RuntimeException.class, () -> {
            int_deque.removeLast();
        });
    }

    @Test
    /* Test the getRecursive method */
    public void getRecursiveShouldGiveTheSameResultAsGet() {
        LinkedListDeque<Integer> int_deque = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            int_deque.addLast(i);
        }
        assertEquals((int) int_deque.get(4), (int) int_deque.getRecursive(4));
    }

    @Test
    /* Test the equals method */
    public void twoDequesWithIdenticalElementsShouldEqual() {
        LinkedListDeque<Integer> dequeOne = new LinkedListDeque<>();
        LinkedListDeque<Integer> dequeTwo = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            dequeOne.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            dequeTwo.addLast(i);
        }

        boolean dequeOneEqualsDequeTwo = dequeOne.equals(dequeTwo);
        assertEquals(true, dequeOneEqualsDequeTwo);
    }

    @Test
    /* Test the equals method */
    public void twoDequesWithDifferentElementsShouldNotEqual() {
        LinkedListDeque<Integer> dequeOne = new LinkedListDeque<>();
        LinkedListDeque<Integer> dequeTwo = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            dequeOne.addLast(i);
        }
        for (int i = 9; i >= 0; i--) {
            dequeTwo.addLast(i);
        }

        boolean dequeOneNotEqualDequeTwo = dequeOne.equals(dequeTwo);
        assertEquals(false, dequeOneNotEqualDequeTwo);
    }

    @Test
    /* Test the iterator */
    public void checkIfIteratorIsWorkingProperly() {
        LinkedListDeque<Integer> int_deque = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            int_deque.addLast(i);
        }
        for (int i: int_deque)
            System.out.print(i + " ");
        System.out.println();
        Iterator<Integer> iter = int_deque.iterator();
        iter.next();
        iter.next();
        assertEquals(2, (int) iter.next());
        assertEquals(3, (int) iter.next());
    }
}