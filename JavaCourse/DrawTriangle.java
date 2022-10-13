/*
Goal is to create a program that prints the following figure.
*
**
***
****
*****
 */
public class DrawTriangle {
    public static void drawTriangle (int N) {
        int row = 0;
        while (row < N) {
            int col = 0;
            while (col <= row) {
                System.out.print("*");
                col = col + 1;
            }
            row = row + 1;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        drawTriangle(10);
    }
}