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

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void removingEmptyDequeResultsARuntimeException() {
        LinkedListDeque<Integer> intDeque = new LinkedListDeque<Integer>();

        assertThrows(RuntimeException.class, () -> {
            intDeque.removeFirst();
        });
        assertThrows(RuntimeException.class, () -> {
            intDeque.removeLast();
        });
    }

    @Test
    /* Test the getRecursive method */
    public void getRecursiveShouldGiveTheSameResultAsGet() {
        LinkedListDeque<Integer> intDeque = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            intDeque.addLast(i);
        }
        assertEquals((int) intDeque.get(4), (int) intDeque.getRecursive(4));
    }

    @Test
    /* Test the equals method */
    public void twoDequesWithIdenticalElementsShouldEqual() {
        Deque<Integer> dequeOne = new LinkedListDeque<>();
        Deque<Integer> dequeTwo = new LinkedListDeque<>();
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
        Deque<Integer> dequeOne = new LinkedListDeque<>();
        Deque<Integer> dequeTwo = new LinkedListDeque<>();
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
        LinkedListDeque<Integer> intDeque = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            intDeque.addLast(i);
        }
        for (int i: intDeque)
            System.out.print(i + " ");
        System.out.println();
        Iterator<Integer> iter = intDeque.iterator();
        iter.next();
        iter.next();
        assertEquals(2, (int) iter.next());
        assertEquals(3, (int) iter.next());
    }

    @Test
    /* Test the contains() method */
    public void helloWorldDoesNotHaveMyBeautiful() {
        Deque<String> stringDeque = new LinkedListDeque<>();
        stringDeque.addFirst("Hello");
        stringDeque.addLast("World!");
        assertTrue(stringDeque.contains("Hello"));
        assertFalse(stringDeque.contains("my beautiful"));
    }

    @Test
    public void usingPrintlnWillPrintOutEveryItemInTheList() {
        Deque<String> stringDeque = new LinkedListDeque<>();
        stringDeque.addFirst("I");
        stringDeque.addLast("love");
        stringDeque.addLast("Python");
        assertEquals("I, love, Python", stringDeque.toString());
        System.out.println(stringDeque);
    }
}