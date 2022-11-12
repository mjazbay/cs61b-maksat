package lecture5;

import lecture3.IntList;

public class SLList {

    private static class IntNode {
        int value;
        IntNode next;
        public IntNode(int v, IntNode n) {
            this.value = v;
            this.next = n;
        }

        public String toString() {
            if (next == null) {
                // Converts an Integer to a String!
                return String.valueOf(value);
            } else {
                return value + " -> " + next.toString();
            }
        }
    }

    IntNode sentinel;
    int size;
    public SLList() {
        sentinel = new IntNode(16, null);
        size = 0;
    }
    public SLList(int f) {
        this.sentinel = new IntNode(16, null);
        this.sentinel.next = new IntNode(f, null);
        size = 1;
    }

    public void addFirst(int value) {
        this.sentinel.next = new IntNode(value, this.sentinel.next);
        size++;
    }

    /*iterative solution*/
    public void addLast(int v) {
        size++;
        IntNode p = this.sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(v, null);
    }
    /*recursive solution*/
    public void addLastRecursively(int v)
    {
        System.out.println("fail");
    }

    /*return the size of the list that starts at IntNode p
    * Resursive solution
    * */
    private static int sizeRecursively(IntNode start) {
        if (start != null) return 1 + sizeRecursively(start.next);
        return 0;
    }
    public int sizeRecursively() {
        return sizeRecursively(sentinel);
    }
    public int size(){
        return this.size;
    }

    /*modifies the list so that all of its elements are squared*/
    public static void dSquareList(SLList L) {
        dSquareList(L.sentinel.next);
    }
    public static void dSquareList(IntNode start) {
        if (start == null) return;
        start.value *= start.value;
        dSquareList(start.next);
    }

    /*Returns a version of the list with all elements squared, using iteration.
    * The list is not modified.
    *  */
    public static SLList squareListIterative(SLList L) {
        SLList newList = new SLList();
        IntNode p = L.sentinel.next;
        while (p != null) {
            newList.addLast(p.value * p.value);
            p = p.next;
        }
        return newList;
    }
    /*returns a version of the list with all elements squared, using recursion. The list is not modified.*/
    public static SLList squareListRecursive(SLList L) {
        return squareListRecursive(L.sentinel.next, new SLList());
    }
    public static SLList squareListRecursive(IntNode curNode, SLList newList) {
        if (curNode == null) return newList;
        newList.addLast(curNode.value * curNode.value);
        return squareListRecursive(curNode.next, newList);
    }

    /*returns a list consisting of all elements of A, followed by all elements of B.
    May modify A.
    */
    public static void dcatenate(SLList A, SLList B) {
        dcatenate(A, B.sentinel.next);
    }
    public static void dcatenate(SLList list, IntNode node) {
        if (node == null) return;
        list.addLast(node.value);
        dcatenate(list, node.next);
    }

    /*returns a list consisting of all elements of A, followed by all elements of B.
    May NOT modify A.
    */
    public static SLList catenate(SLList A, SLList B) {
        if (A == null || B == null) return A == null ? B : B == null ? A : null;
        return catenate(catenate(new SLList(), A.sentinel.next), B.sentinel.next);
    }
    public static SLList catenate(SLList list, IntNode node) {
        if (node == null) return list;
        list.addLast(node.value);
        return catenate(list, node.next);
    }

    public void printList() {
        System.out.println(this.sentinel.next.toString());
    }
    public String stringify() {
        return this.sentinel.next.toString();
    }

    public static SLList of(int ...argList) {
        if (argList.length == 0)
            return null;
        int[] restList = new int[argList.length - 1];
        System.arraycopy(argList, 1, restList, 0, argList.length - 1);
        if (restList.length == 0) {
            return new SLList(argList[0]);
        }
        return SLList.catenate(new SLList(argList[0]), SLList.of(restList));
    }

    /*destroys the list*/
    public static void dSquareListIterative(SLList L) {
        while (L.sentinel.next != null) {
            L.sentinel.next.value *= L.sentinel.next.value;
            L.sentinel.next = L.sentinel.next.next;
        }
    }

    public static void main(String[] args) {
        SLList origL = SLList.of(1, 2, 3);
    }
}
