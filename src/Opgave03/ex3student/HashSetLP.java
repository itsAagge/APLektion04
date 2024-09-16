package Opgave03.ex3student;

import org.w3c.dom.Node;

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
        int i = hash(element);
        int count = 0;
        while (count < table.length) {
            if (table[i] == null || table[i] == deleted) return false;
            if (table[i] == element) return true;
            if (count == table.length - 1) {
                i = 0;
            } else {
                i++;
            }
            count++;
        }
        return false;
    }

    /**
     * Add element to the set.
     * Returns true, if the element is added to the set.
     * Pre: element != null.
     */
    public boolean add(E element) {
        int i = hash(element);
        int count = 0;
        while (count < table.length) {
            if (table[i] == null || table[i] == deleted) {
                table[i] = element;
                size++;
                if ((size * 1.0) / table.length > 0.5) rehash();
                return true;
            }
            if (count == table.length - 1) {
                i = 0;
            } else {
                i++;
            }
            count++;
        }
        return false;
    }

    /**
     * Remove element from the set.
     * Returns true, if the element is removed from the set.
     * Pre: element != null.
     */
    public boolean remove(E element) {
        if (this.contains(element)) {
            int i = hash(element);
            int count = 0;
            while (count < table.length) {
                if (table[i] == null || table[i] == deleted) return false;
                if (table[i] == element) {
                    table[i] = deleted;
                    size--;
                    return true;
                }
                if (count == table.length - 1) {
                    i = 0;
                } else {
                    i++;
                }
                count++;
            }
        }
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
        String s = "";
        for (E e : table) {
            if (e != null && e != deleted) s += e + " ";
        }
        return s;
    }

    private void rehash() {
        E[] oldTable = table;
        @SuppressWarnings("unchecked")
        E[] emptyTable = (E[]) new Object[oldTable.length * 2];
        table = emptyTable;
        size = 0;
        for (E e : oldTable) {
            if (e != null && e != deleted) {
                this.add(e);
            }
        }
    }
}
