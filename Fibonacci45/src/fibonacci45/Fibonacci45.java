package fibonacci45;

public class Fibonacci45 {

    public static long fibonacciLoop(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static long finaboncciLop(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, c;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.print("The 45 sequence Fibonacci:\n");

        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacciLoop(i));
            if (i < 44) {
                System.out.print(", ");
            }
        }
    }
}
