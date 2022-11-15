package lecture6;
import lecture5.SLList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCircularGenericList {
    @Test
    public void testEmptyList() {
        ListCircularSentinel<Integer> list = new ListCircularSentinel<>();
        assertEquals("{}", list.stringify());
    }
    @Test
    public void testListWithInitialValue() {
        ListCircularSentinel<Integer> list = new ListCircularSentinel<>(10);
        assertEquals("10", list.stringify());
        assertNotEquals("10 ->", list.stringify());
    }
    @Test
    public void testAddFirst() {
        ListCircularSentinel<String> stringList = new ListCircularSentinel<>();
        ListCircularSentinel<Integer> intList = new ListCircularSentinel<>();
        stringList = stringList.of("one", "two", "three");
        intList = intList.of(1,2,3);

        stringList.addFirst("10");
        intList.addFirst(10);

        assertEquals("10 -> one -> two -> three", stringList.stringify());
        assertEquals("10 -> 1 -> 2 -> 3", intList.stringify());
    }

    @Test
    public void testAddLast() {
        ListCircularSentinel<String> stringList = new ListCircularSentinel<>();
        ListCircularSentinel<Integer> intList = new ListCircularSentinel<>();
        stringList = stringList.of("one", "two", "three");
        intList = intList.of(1,2,3);

        stringList.addLast("99");
        intList.addLast(99);

        assertEquals("one -> two -> three -> 99", stringList.stringify());
        assertEquals("1 -> 2 -> 3 -> 99", intList.stringify());
    }
    @Test
    public void testRemoveLast() {
        ListCircularSentinel<String> stringList = new ListCircularSentinel<>();
        ListCircularSentinel<Integer> intList = new ListCircularSentinel<>();
        stringList = stringList.of("one", "two", "three");
        intList = intList.of(1,2,3);

        stringList.removeLast();
        intList.removeLast();

        assertEquals("one -> two", stringList.stringify());
        assertEquals("1 -> 2", intList.stringify());
    }
    @Test
    public void testStringify() {
        ListCircularSentinel<String> stringList = new ListCircularSentinel<>();
        ListCircularSentinel<Integer> intList = new ListCircularSentinel<>();
        stringList = stringList.of("one", "two", "three");
        intList = intList.of(1,2,3);

        assertEquals("one -> two -> three", stringList.stringify());
        assertEquals("1 -> 2 -> 3", intList.stringify());
    }
}
