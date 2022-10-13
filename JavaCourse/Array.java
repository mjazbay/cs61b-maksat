public class Array {
    /** Returns the maximum value from arr. */
    public static int whileMax(int[] arr) {
        int i = 1;
        int maxNum = arr[0];
        while (i < arr.length) {
            maxNum = max(maxNum, arr[i]);
            i++;
        }
        return maxNum;
    }

    public static int forMax(int[] arr) {
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxNum = max(maxNum, arr[i]);
        }
        return maxNum;
    }

    public static int max(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void skipHorse() {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        for (int i = 0; i < a.length; i += 1) {
            if (a[i].contains("horse")) {
                continue;
            }
            for (int j = 0; j < 3; j += 1) {
                System.out.println(a[i]);
            }
        }
    }

    public static void onceHorse() {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        for (int i = 0; i < a.length; i += 1) {
            for (int j = 0; j < 3; j += 1) {
                System.out.println(a[i]);
                if (a[i].contains("horse")) {
                    break;
                }
            }
        }
    }

    //enhanced for loop
    public static void enhancedForLoop() {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        for(String s: a) {
            for (int j = 0; j < 3; j += 1) {
                System.out.println(s);
                if (s.contains("horse")) {
                    break;
                }
            }
        }
    }

    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) continue;
            for (int j = i + 1; j <= i + n; j++) {
                if (j >= a.length) break;
                a[i] += a[j];
            }
        }
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        // System.out.println(whileMax(numbers));
        // System.out.println(forMax(numbers));
        // System.out.println(sum(numbers));
        // skipHorse();
        // onceHorse();
        int[] a = {1, 2, -3, 4, 5, 4};
        int[] b = {1, -1, -1, 10, 5, -1};
        int n = 3;
        windowPosSum(a, n);
        windowPosSum(b, 2);
        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
        System.out.println(java.util.Arrays.toString(b));
        enhancedForLoop();
    }
}

