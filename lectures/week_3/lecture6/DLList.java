package lecture6;

public class DLList {

    private static class IntNode {
        int value;
        IntNode next;
        IntNode prev;
        public IntNode(int v, IntNode n, IntNode p) {
            this.value = v;
            this.next = n;
            this.prev = p;
        }

        public String toString() {
            if (value == 61) return "";
            if (value == 16) return next.toString();
            return next.next == null ? String.valueOf(value) : value + " -> " + next.toString();
        }
    }

    IntNode sentFront;
    IntNode sentBack;
    int size;

    public DLList() {
        sentFront = new IntNode(16, null, null);
        sentBack = new IntNode(61, null, sentFront);
        sentFront.next = sentBack;
        size = 0;
    }
    public DLList(int f) {
        this.sentFront = new IntNode(16, null, null);
        this.sentFront.next = new IntNode(f, null, null);
        this.sentFront.next.prev = this.sentFront;
        this.sentBack = new IntNode(61, null, this.sentFront.next);
        this.sentFront.next.next = this.sentBack;
        size = 1;
    }

    public void addFirst(int value) {
        IntNode node = new IntNode(value, null, this.sentFront);
        this.sentFront.next.prev = node;
        node.next = this.sentFront.next;
        this.sentFront.next = node;
        size++;
    }

    /*iterative solution*/
    public void addLast(int v) {
        size++;
        IntNode p = this.sentFront;
        while (p.next != null) {
            p = p.next;
        }
        //find the last sentinel
        IntNode newNode = new IntNode(v, p, p.prev);
        p.prev.next = newNode;
        p.prev = newNode;
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
        return sizeRecursively(sentFront);
    }
    public int size(){
        return this.size;
    }

    public String stringify() {
        return this.sentFront.toString();
    }
    public void printList() {
        System.out.println(this.sentFront.toString());
    }

    public static DLList catenate(DLList A, DLList B) {
        if (A == null || B == null) return A == null ? B : B == null ? A : null;
        return catenate(catenate(new DLList(), A.sentFront.next), B.sentFront.next);
    }
    public static DLList catenate(DLList list, IntNode node) {
        if (node == null || node.next == null) return list;
        list.addLast(node.value);
        return catenate(list, node.next);
    }
    public static DLList of(int ...argList) {
        if (argList.length == 0)
            return null;
        int[] restList = new int[argList.length - 1];
        System.arraycopy(argList, 1, restList, 0, argList.length - 1);
        if (restList.length == 0) {
            return new DLList(argList[0]);
        }
        return DLList.catenate(new DLList(argList[0]), DLList.of(restList));
    }

    public static void main(String[] args) {
        DLList origL = DLList.of(1, 2, 3);
        origL.addFirst(10);
        origL.addLast(20);
        origL.printList();
    }
}
