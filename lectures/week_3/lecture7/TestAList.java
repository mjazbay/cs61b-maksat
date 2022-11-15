package lecture7;

import org.junit.Test;

import java.security.AllPermission;

import static org.junit.Assert.*;

public class TestAList {
    @Test
    public void testAddLast() {
        Alist aList = new Alist();
        aList.addLast(10);
        assertEquals(aList.getLast(), 10);
        assertEquals(aList.size(), 1);
    }
    @Test
    public void testGet() {
        Alist aList = new Alist();
        aList.addLast(10);
        aList.addLast(20);
        assertEquals(aList.get(0), 10);
        assertEquals(aList.get(1), 20);
    }
    @Test
    public void testGetLast() {
        Alist aList = new Alist();
        aList.addLast(10);
        aList.addLast(20);
        assertEquals(aList.getLast(), 20);
    }
    @Test
    public void testRemoveLast() {
        Alist aList = new Alist();
        aList.addLast(10);
        aList.addLast(20);
        Object last = aList.removeLast();
        assertEquals(last, 20);
        assertEquals(aList.size(), 1);
        assertEquals(aList.getLast(), 10);
    }
    @Test
    public void testResize() {
        Alist aList = new Alist();
        int i = 0;
        while (i < 1000 ) {
            aList.addLast(i);
            i++;
        }
        assertEquals(aList.size(), 1000);
        assertEquals(aList.getLast(), 999);
        assertEquals(aList.get(100), 100);
    }
    @Test
    public void testLoadFactorBelow25() {
        Alist aList = new Alist();
        int i = 0;
        while (i < 100 ) {
            aList.addLast(i);
            i++;
        }
        while(i > 20) {
            aList.removeLast();
            i--;
        }
        assertEquals(aList.itemsLength(), 50);
    }
    @Test
    public void testGenericList() {
        Alist list = new Alist();
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");

        assertEquals(list.getLast(), "three");
        assertEquals(list.removeLast(), "three");
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "one");
    }
}
