package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    /* Test the iterator */
    public void testingIterator() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 4; i++)
            ad.addFirst(i);
        for (int i = 4; i < 8; i++)
            ad.addLast(i);
        for (int i: ad)
            System.out.print(i + " ");
        System.out.println();
        Iterator<Integer> iter = ad.iterator();
        iter.next();
        iter.next();
        assertEquals(1, (int) iter.next());
        assertEquals(0, (int) iter.next());
    }

    @Test
    /* Test the contains() method */
    public void containsShouldReturnABooleanValue() {
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.addFirst("Go");
        stringDeque.addLast("Bears!");
        assertTrue(stringDeque.contains("Bears!"));
        assertFalse(stringDeque.contains("bears!"));
    }
}
