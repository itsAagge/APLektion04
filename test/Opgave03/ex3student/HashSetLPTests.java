package Opgave03.ex3student;

import Opgave02.ex2student.HashSetSC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashSetLPTests {
    HashSetLP<Integer> myInts;
    @BeforeEach
    void setUp() {
        myInts = new HashSetLP<>(17);
        myInts.add(42);
    }

    @Test
    void contains() {
        assertTrue(myInts.contains(42));
        assertFalse(myInts.contains(34));
    }

    @Test
    void add() {
        int myInt = 20;
        myInts.add(myInt);
        assertTrue(myInts.contains(myInt));
    }

    @Test
    void remove() {
        myInts.remove(42);
        assertFalse(myInts.contains(42));
        assertFalse(myInts.remove(11));
    }

    @Test
    void toStringTest() {
        myInts.add(23);
        myInts.add(89);
        myInts.add(11);
        System.out.println(myInts.toString());
        assertNotNull(myInts.toString());
    }

    @Test
    void size() {
        assertEquals(1, myInts.size());
        myInts.add(12);
        assertEquals(2, myInts.size());
        myInts.remove(42);
        assertEquals(1, myInts.size());
    }

    @Test
    void rehash() {
        HashSetLP<Integer> set = new HashSetLP<>(2);
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.size());
    }
}
