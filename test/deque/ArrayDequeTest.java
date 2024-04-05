package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    /** Test the remove operations */
    public void testingRemoveOperation() {
        ArrayDeque<Integer> intArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 5; i++)
            intArrayDeque.addFirst(i);
        for (int i = 0; i < 2; i++)
            intArrayDeque.addLast(i + intArrayDeque.size());

        int removedFirst = intArrayDeque.removeFirst();
        int removedLast = intArrayDeque.removeLast();
        int removedFirstAgain = intArrayDeque.removeFirst();

        assertEquals(4, removedFirst);
        assertEquals(7, removedLast);
        assertEquals(3, removedFirstAgain);
        assertTrue("The size of the ArrayDeque should be 4", intArrayDeque.size() == 4);
    }

    @Test
    /** Test the get operation */
    public void testingGetMethod() {
        ArrayDeque<Integer> intArrayDeque = new ArrayDeque<>();
        intArrayDeque.addFirst(4);
        intArrayDeque.addLast(5);
        intArrayDeque.addFirst(3);
        intArrayDeque.addLast(6);
        
        assertEquals(3, (int) intArrayDeque.get(0));
        assertEquals(4, (int) intArrayDeque.get(1));
        assertEquals(5, (int) intArrayDeque.get(2));
        assertEquals(6, (int) intArrayDeque.get(3));
        assertThrows(RuntimeException.class, () -> {
            intArrayDeque.get(4);
        });
    }
}
