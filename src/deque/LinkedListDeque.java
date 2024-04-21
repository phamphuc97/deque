package deque;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node(T e, Node p, Node n) {
            item = e;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** Initiate an empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    /** Add an item to the beginning of the list */
    public void addFirst(T item) {
        sentinel.next.prev = new Node(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size++;
    }

    @Override
    /** Add an item at the end of the list */
    public void addLast(T item) {
        sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    @Override
    /** Return number of items in the deque */
    public int size() {
        return size;
    }

    @Override
    /** Print the items in the deque from first to last */
    public void printDeque() {
        Node current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    /** Removes and returns the item at the front of the deque */
    public T removeFirst() {
        if (size == 0) {
            throw new RuntimeException("There is no element to remove");
        }
        T removedItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removedItem;
    }

    @Override
    /** Removes and returns the item at the back of the deque */
    public T removeLast() {
        if (size == 0) {
            throw new RuntimeException("There is no element to remove");
        }
        T removedItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removedItem;
    }

    @Override
    /** Gets the item at the given index */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node current = sentinel.next;
        int startIndex = 0;
        while (startIndex < index) {
            current = current.next;
            startIndex++;
        }
        return current.item;
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursive(index, 0, sentinel.next);
    }

    /** Helper method for getRecursive() */
    private T getRecursive(int index, int currentIndex, Node current) {
        if (currentIndex == index) {
            return current.item;
        }
        return getRecursive(index, currentIndex + 1, current.next);
    }

    @Override
     // Check if the item exists in the list
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (get(i) == item) {
                return true;
            }
        }
        return false;
    }


    /** Returns whether the parameter o is equal to the Deque */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other instanceof Deque && (this.size() == ((Deque<?>) other).size())) {
            Deque<T> otherDeque = (Deque<T>) other;
            for (int i = 0; i < size; i++) {
                if (!otherDeque.get(i).equals(this.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /** Return an iterator */
    public java.util.Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements java.util.Iterator<T> {
        private int pos;

        LinkedListDequeIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T returnedItem = get(pos);
            pos++;
            return returnedItem;
        }
    }


     @Override
     // Convert the list to string
     public String toString() {
         StringBuilder newString = new StringBuilder("[");
         for (int i = 0; i < size - 1; i++) {
             newString.append(get(i));
             newString.append(", ");
         }
         newString.append(get(size - 1));
         newString.append("]");
         return newString.toString();
     }


    /**
     @Override
     // Compare the size of two lists
     public int compareTo(Object o) {
     LinkedListDeque other = (LinkedListDeque) o;
     if (this.size < other.size())
     return -1;
     else if (this.size == other.size())
     return 0;
     return 1;
     }
     */
}
