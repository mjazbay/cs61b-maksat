package lecture5;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSLList {
    /*asertEquals assertArrayEquals*/
    @Test
    public void testDSquareList() {
        SLList list = SLList.of(30, 10, -20);
        SLList.dSquareList(list);
        assertEquals("900 -> 100 -> 400", list.stringify());
    }

    @Test
    public void testSquareListIterative() {
        SLList list = SLList.of(30, 10, -20);
        SLList list2 = SLList.squareListIterative(list);
        System.out.println(list.stringify());
        System.out.println(list2.stringify());
        assertNotEquals(list2, list);
    }
    @Test
    public void testSquareListRecursive() {
        SLList list = SLList.of(30, 10, -20);
        SLList list2 = SLList.squareListIterative(list);
        assertNotEquals(list2, list);
    }
    @Test
    public void testDcatenate() {
        SLList list = SLList.of(-20, 30, 10);
        SLList list2 = SLList.of(30, 10, -20);
        SLList.dcatenate(list, list2);
        assertEquals("-20 -> 30 -> 10 -> 30 -> 10 -> -20", list.stringify());
    }
    @Test
    public void testCatenate() {
        SLList list = SLList.of(-20, 30, 10);
        SLList list2 = SLList.of(30, 10, -20);
        SLList list3 = SLList.catenate(list, list2);
        assertNotEquals("-20 -> 30 -> 10 -> 30 -> 10 -> -20", list.stringify());
        assertEquals("-20 -> 30 -> 10 -> 30 -> 10 -> -20", list3.stringify());
        SLList list4 = SLList.catenate(null, list2);
        assertEquals("30 -> 10 -> -20", list4.stringify());
        SLList list5 = SLList.catenate(new SLList(), list);
        assertEquals("-20 -> 30 -> 10", list5.stringify());
    }
}

