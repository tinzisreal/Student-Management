package fibonacci;

public class Fibonacci {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.print("The 45 sequence Fibonacci:\n");

        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacci(i));
            if (i < 44) {
                System.out.print(", ");
            }
        }
    }
}