package Opgave02.ex2student;

import org.w3c.dom.Node;

/**
 * HashSetSC implements a hash set using separate chaining.
 * Note: null is not allowed as an element in the set.
 */
public class HashSetSC<E> {
    // the hash table where each entry contains
    // a collection of elements with the same hash value;
    // each collection is implemented as a single linked list
    private Node<E>[] table;
    // the number of elements in the hash set
    private int size;

    /**
     * Create a new HashSetSC with the given table length.
     * Note: The table length should be a prime number.
     */
    public HashSetSC(int tableLength) {
        @SuppressWarnings("unchecked")
        Node<E>[] emptyTable = (Node<E>[]) new Node[tableLength];
        table = emptyTable;
        size = 0;
    }

    // Pre: element!= null.
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
        Node<E> node = table[hash(element)];
        while (node != null) {
            if (node.data.equals(element)) return true;
            node = node.next;
        }
        return false;
    }

    /**
     * Add element to this set.
     * Return true, if the element is added to the set.
     * Pre: element != null.
     */
    public boolean add(E element) {
        if (this.contains(element)) return false;
        int hash = hash(element);
        Node<E> node = new Node<>(element);
        if (table[hash] != null) {
            node.next = table[hash];
        }
        table[hash] = node;
        size++;
        if ((size * 1.0) / table.length > 0.75) rehash();
        return true;
    }

    /**
     * Remove element from the set.
     * Return true, if the element is removed from the set.
     * Pre: element != mull.
     */
    public boolean remove(E element) {
        if (!this.contains(element)) {
            return false;
        } else {
            int hash = hash(element);
            Node<E> node = table[hash];
            if (node.data.equals(element)) {
                if (node.next != null) table[hash] = node.next;
                else table[hash] = null;
                size--;
                return true;
            } else {
                while (!node.next.data.equals(element)) {
                    node = node.next;
                }
                if (node.next.next != null) node.next = node.next.next;
                else node.next = null;
                size--;
                return true;
            }
        }
    }

    /**
     * Return the number of elements in this set.
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Node<E> node = table[i];
                s += node.data.toString() + " ";
                while (node.next != null) {
                    node = node.next;
                    s += node.data;
                    if (node.next != null) s += " ";
                }
            }
        }
        return s;
    }

    private void rehash() {
        Node<E>[] oldTable = table;
        @SuppressWarnings("unchecked")
        Node<E>[] emptyTable = (Node<E>[]) new Node[oldTable.length * 2];
        table = emptyTable;
        size = 0;
        for (Node<E> node : oldTable) {
            while (node != null) {
                this.add(node.data);
                node = node.next;
            }
        }
    }

    //-------------------------------------------------------------------------

    private static class Node<T> {
        final T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
