package lecture7;

public class Alist<Item> {
    private int size;
    private Item[] items;
    public Alist() {
        size = 0;
        items = (Item[]) new Object[100];
    }
    public void addLast(Item item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
        size++;
    }
    public Item removeLast() {
        Item last = getLast();
        items[size - 1] = null;
        size--;
        float loadFactor = (float) size / items.length;
        if (loadFactor < 0.25) {
            resize(items.length/2);
        }
        return last;
    }
    public Item get(int index) {
        return items[index];
    }
    public Item getLast() {
        return items[size - 1];
    }
    public int size() {
        return size;
    }
    public int itemsLength() { return items.length; }
    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
}
