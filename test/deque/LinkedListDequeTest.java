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
        Deque<String> stringDeque = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", stringDeque.isEmpty());
        stringDeque.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, stringDeque.size());
        assertFalse("stringDeque should now contain 1 item", stringDeque.isEmpty());

        stringDeque.addLast("middle");
        assertEquals(2, stringDeque.size());

        stringDeque.addLast("back");
        assertEquals(3, stringDeque.size());
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void aDequeShouldBeEmptyAfterAddingAndRemovingAnItem() {
        Deque<Integer> intDeque = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("intDeque should be empty upon initialization", intDeque.isEmpty());

        intDeque.addFirst(10);
        // should not be empty
        assertFalse("intDeque should contain 1 item", intDeque.isEmpty());

        intDeque.removeFirst();
        // should be empty
        assertTrue("intDeque should be empty after removal", intDeque.isEmpty());
    }
}