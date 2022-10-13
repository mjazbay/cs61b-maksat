public class LogicalOperators {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;

        if (x < 10 && y > 5) {
            System.out.println(x + y);
        }

        if (x + 1 > 6 && x * x != 25 || x + 5 < 10 && x / 2 > 0)
            System.out.println(x);

        int bottles = 99;
        while (bottles > 0) {
            System.out.println(bottles + "bottles of beer on the wall.");
            bottles = bottles - 1;
        }

    }
}