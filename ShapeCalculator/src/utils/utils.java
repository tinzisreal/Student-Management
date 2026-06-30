package utils;

import java.util.Scanner;

public class utils {

    public static double getInputPositiveDouble(Scanner sc, String message) {
        double number;
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Must be a positive number, please enter again.");
                }
            } else {
                System.out.println("Invalid input, must be a number.");
                sc.next();
            }
        }
    }

    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
