package lecture3;

public class IntList {
    int first;
    IntList rest;
    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.get(1));
        IntList N = IntList.incrList(L, 5);
        System.out.println(N);
        IntList D = IntList.dincrList(N, 100);
        System.out.println(D);
    }

    /*recursive solution for getSize*/
    public int size() {
        if (this.rest == null) return 1;
        return 1 + this.rest.size();
    }
    /*iterative solution for getSize*/
    public int getSize() {
        int count = 0;
        IntList list = this;
        while (list != null) {
            count++;
            list = list.rest;
        }
        return count;
    }

    /*recursive solution for getElementAtIndex*/
    public int get(int i) {
        if (i == 0) return this.first;
        i--;
        return this.rest.get(i);
    }

    /*
    * Returns an IntList identical to L, but with all values incremented by x.
    * Values in L cannot change!
    * * */
    public static IntList incrList(IntList L, int x) {
        if (L.rest == null) return new IntList(L.first + x, null);
        return new IntList(L.first + x, IntList.incrList(L.rest, x));
    }

    /*
    * Returns an IntList identical to L, but with all values incremented by x.
    * Not allowed to use ‘new’ (to save memory).3
    * */
    public static IntList dincrList(IntList L, int x) {
        L.first += x;
        if (L.rest == null) return L;
        IntList.dincrList(L.rest, x);
        return L;
    }
}
