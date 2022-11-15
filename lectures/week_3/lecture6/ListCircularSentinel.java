package lecture6;

import java.util.List;

public class ListCircularSentinel<ListType> {

    private static class TypeNode<ListType> {
        ListType value;
        TypeNode next;
        TypeNode prev;
        public TypeNode(ListType v, TypeNode n, TypeNode p) {
            this.value = v;
            this.next = n;
            this.prev = p;
        }

        public String toString() {
            if (value == null) return "{}";
            if (next.value == null) return String.valueOf(value);
            return value + " -> " + next.toString();
        }
    }

    TypeNode sentinel;
    TypeNode last;
    TypeNode first;
    int size;

    public ListCircularSentinel() {
        sentinel = new TypeNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public ListCircularSentinel(ListType f) {
        sentinel = new TypeNode(null, null, null);
        TypeNode newNode = new TypeNode(f, sentinel, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
        last = newNode;
        first = newNode;
        size = 1;
    }

    public void addFirst(ListType value) {
        TypeNode newNode = new TypeNode(value, first, sentinel);
        first.prev = newNode;
        sentinel.next = newNode;
        first = newNode;
        size++;
    }
    public void addLast(ListType value) {
        if (size == 0) {
            TypeNode newNode = new TypeNode(value, sentinel, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
            first = newNode;
            last = newNode;
        } else {
            TypeNode newNode = new TypeNode(value, sentinel, last);
            last.next = newNode;
            sentinel.prev = newNode;
            last = newNode;
        }
        size++;
    }
    public void removeLast() {
        last = last.prev;
        last.next = sentinel;
        sentinel.prev = last;
        if (size == 0) {
            first = sentinel;
            last = sentinel;
            return;
        }
        size--;
    }


    /*return the size of the list that starts at IntNode p*/
    public int size(){
        return this.size;
    }

    public String stringify() {
        return this.sentinel.next.toString();
    }
    public void printList() {
        System.out.println(this.sentinel.next.toString());
    }

    public static ListCircularSentinel catenate(ListCircularSentinel A, ListCircularSentinel B) {
        if (A == null || B == null) return A == null ? B : B == null ? A : null;
        return catenate(catenate(new ListCircularSentinel(), A.first), B.first);
    }
    public static ListCircularSentinel catenate(ListCircularSentinel list, TypeNode node) {
        if (node == null || node.value == null) return list;
        list.addLast(node.value);
        return catenate(list, node.next);
    }
    public ListCircularSentinel of(ListType...argList) {
        if (argList.length == 0) return  null;
        ListCircularSentinel list = new ListCircularSentinel();
        for (ListType x : argList) {
            list.addLast(x);
        }
        return list;
    }
}
