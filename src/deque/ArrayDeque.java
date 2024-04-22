package deque;

// An array deque offers constant-time insertion and deletion operations at both ends of the array,
// providing dynamic resizing to accommodate varying numbers of elements efficiently.
public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Initiate an empty ArrayDeque */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
    }

    @Override
    /** Add an item to the beginning of the ArrayDeque */
    public void addFirst(T item) {
        if (size == 0) {
            items[nextFirst] = item;
            nextFirst = items.length - 1;
            nextLast++;
            size++;
            return;
        }
        if (size == items.length) {
            resize(size * 2);
        }
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    @Override
    /** Add an item to the end of the ArrayDeque */
    public void addLast(T item) {
        if (size == 0) {
            items[nextLast] = item;
            nextLast++;
            nextFirst = items.length - 1;
            size++;
            return;
        }
        if (size == items.length) {
            resize(size * 2);
        }
        if (nextLast == items.length) {
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast++;
        size++;
    }

    @Override
    /** Return number of items in the deque */
    public int size() {
        return size;
    }

    @Override
    /** Removes and returns the item at the front of the deque */
    public T removeFirst() {
        if (size == 0) {
            throw new RuntimeException("There is no element to remove");
        }
        if (items.length >= 16 && size == 0.25 * items.length) {
            resize(items.length / 2);
        }
        if (nextFirst == items.length - 1 && size > 0) {
            nextFirst = -1;
        }
        T removedItem = items[nextFirst + 1];
        nextFirst = nextFirst + 1;
        items[nextFirst] = null;
        size--;
        if (size == 0) {
            nextFirst = 0;
            nextLast = 0;
        }
        return removedItem;
    }

    @Override
    /** Removes and returns the item at the back of the deque */
    public T removeLast() {
        if (size == 0) {
            throw new RuntimeException("There is no element to remove");
        }
        if (items.length >= 16 && size == 0.25 * items.length) {
            resize(items.length / 2);
        }
        if (nextLast == 0 && size > 0) {
            nextLast = items.length;
        }
        T removedItem = items[nextLast - 1];
        nextLast = nextLast - 1;
        items[nextLast] = null;
        size--;
        if (size == 0) {
            nextFirst = 0;
            nextLast = 0;
        }
        return removedItem;
    }

    @Override
    /** Get the item at the given index */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds!");
        } else {
            return items[(index + nextFirst + 1) % items.length];
        }
    }

    /** Resize the deque */
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        if (nextFirst == -1) {
            System.arraycopy(items, 0, newItems, 0, size);
        } else if (items[0] == null) {
            System.arraycopy(items, nextFirst + 1, newItems, 0, size);
        } else {
            System.arraycopy(items, nextFirst + 1, newItems, 0, items.length - (nextFirst + 1));
            System.arraycopy(items, 0, newItems, items.length - nextFirst - 1, nextLast);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Deque && (this.size() == ((Deque<?>) o).size())) {
            Deque<T> other = (Deque<T>) o;
            for (int i = 0; i < size; i++) {
                if (!other.get(i).equals(this.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /** Return an iterator */
    public java.util.Iterator<T> iterator() {
        return new ArrayDeque.ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements java.util.Iterator<T> {
        private int pos;

        ArrayDequeIterator() {
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
     // Convert the list to string, each separated by a comma
     public String toString() {
         StringBuilder newString = new StringBuilder();
         for (int i = 0; i < size - 1; i++) {
             newString.append(get(i));
             newString.append(", ");
         }
         newString.append(get(size - 1));
         return newString.toString();
     }
}
