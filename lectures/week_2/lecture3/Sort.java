package lecture3;

public class Sort {

    public static void sort(String[] input) {
        sort(input, 0);
    }

    public static void sort(String[] input, int start) {
        if (start == input.length ) return;
        int smallest = findSmallest(input, start);
        swap(input, start, smallest);
        sort(input, start + 1);
    }
    public static int findSmallest(String[] input, int start) {
        int currentSmallest = start;
        for (int i = start; i < input.length; i++) {
            int result = input[i].compareTo(input[currentSmallest]);
            if (result < 0) {
                currentSmallest = i;
            }
        }
        return currentSmallest;
    }

    public static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}