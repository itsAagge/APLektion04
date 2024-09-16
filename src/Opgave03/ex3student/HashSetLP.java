package ex3student;

/**
 * HashSetLP implements a hash set using linear probing.
 * Note: null is not allowed as an element in the set.
 */
public class HashSetLP<E> {
    // the hash table
    private E[] table;
    // the number of elements in the hash set
    private int size;
    // the special value used to mark an earlier occupied entry as free
    @SuppressWarnings("unchecked")
    private final E deleted = (E) new Object();

    /**
     * Create a new HashSetLP with the given table length.
     */
    public HashSetLP(int tableLength) {
        @SuppressWarnings("unchecked")
        E[] emptyTable = (E[]) new Object[tableLength];
        table = emptyTable;
        size = 0;
    }

    // Pre: element != null.
    private int hash(E element) {
        int h = element.hashCode();
        if (h < 0) h = -h;
        h = h % table.length;
        return h;
    }

    /**
     * Return true, if element is in the set.
     * Pre: element != null.
     */
    public boolean contains(E element) {
        // TODO
        return false;
    }

    /**
     * Add element to the set.
     * Returns true, if the element is added to the set.
     * Pre: element != null.
     */
    public boolean add(E element) {
        // TODO
        return false;
    }

    /**
     * Remove element from the set.
     * Returns true, if the element is removed from the set.
     * Pre: element != null.
     */
    public boolean remove(E element) {
        // TODO
        return false;
    }

    /**
     * Return the number of elements in the set.
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }
}
