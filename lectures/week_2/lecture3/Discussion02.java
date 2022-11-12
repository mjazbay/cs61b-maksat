package lecture3;

public class Discussion02 {
    public static int mystery(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while (index < inputArray.length) {
            if (inputArray[index] < x) {
                x = inputArray[index];
                answer = index;
            }
            index = index + 1;
        }
        return answer;
    }

    public static void sortArray(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            int targetIdx = mystery(arr, index);
            int temp = arr[index];
            arr[index] = arr[targetIdx];
            arr[targetIdx] = temp;
            index++;
        }
    }
    /*RECURSIVE SOLUTION*/
    public static int mysteryRecursive(int[] inputArray, int k) {
        return mysteryRecursiveHelper(inputArray, k, inputArray.length - 1);
    }

    public static int mysteryRecursiveHelper(int[] inputArray, int i, int j) {
        if (i == j) {
            return i;
        }
        int index = mysteryRecursiveHelper(inputArray, i+1, j);
        if (inputArray[i] > inputArray[index]) {
            return index;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] input = {3, 0, 4, 6, 3};
        int k = 2;
//        System.out.println(mystery(input, k));
//        sortArray(input);
        System.out.println(mysteryRecursive(input, k));
    }
}