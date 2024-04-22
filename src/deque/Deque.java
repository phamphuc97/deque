package deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    default boolean isEmpty() {
        return size() == 0;
    }
    int size();
    boolean contains(T item);

    T removeFirst();
    T removeLast();
    T get(int index);
}
