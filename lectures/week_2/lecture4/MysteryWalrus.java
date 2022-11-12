package lecture4;

public class MysteryWalrus {
    public static void main(String[] args) {
        /*Reference type example*/
        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        System.out.println(a);//a.weight = 5 because copied bites; aka address aka box and pointer
        System.out.println(b);

        /*Primitive type example*/
        int x = 5;
        int y;
        y = x;
        x = 2;
        System.out.println("x is: " + x);//x = 2 y = 5; because copied bites
        System.out.println("y is: " + y);

        /*72 and H are stored as 01001000
        * how does a piece of Java code know how to interpret 01001000?
        * The answer is through types!
        * c and d variables contain the same bits (well, almost...),
        * but the Java interpreter treats them differently when printed.
         * */
        char c = 'H';
        int d = c;
        System.out.println(c);
        System.out.println(d);

        /*parameter passing aka passing by value*/
        double e = 5.5;
        double f = 10.5;
        double avg = average(e, f);
        /*Here we also copy the bits when you pass params  to function
        * GRoE RULE: In java, copy the bits
        * also called, pass by value.
        *
         * */

        /*test 1*/
        Walrus walrus = new Walrus(3500, 10.5);
        int g = 9;

        doStuff(walrus, g);
        System.out.println(walrus); //walrus.weight reduced to 3400;
        System.out.println(g); //g is unchanged
    }

    public static double average(double a, double b) {
        return (a + b) / 2;
    }

    public static void doStuff(Walrus W, int x) {
        W.weight = W.weight - 100;
        x = x - 5;
    }
}
