package Test.utils;

import java.util.Scanner;
import Test.model.Course;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputInt(Scanner sc, String message, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                int num = Integer.parseInt(sc.nextLine().trim());
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Number must be in range [" + min + ", " + max + "].");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");

            }
        }
    }

    public Course inputCourse(String message) {
        System.out.println(message);
        System.out.println("1. JAVA");
        System.out.println("2. .Net");
        System.out.println("3. C/C++");
        int choice = inputInt(scanner, "Choose course: ", 1, 3);
        return Course.fromChoice(choice);
    }

    public String inputNotEmpty(String message) {
        while (true) {
            System.out.println(message);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            } else {
                System.out.println("Input cannot be empty. Try again.");
            }
        }
    }

    public String inputYesNo(String message) {
        while (true) {
            System.out.println(message);
            String value = scanner.nextLine().trim();
            if (value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("N")) {
                return value;
            } else {
                System.out.println("Please input Y or N.");
            }
        }
    }

    public String inputUpdateDelete(String message) {
        while (true) {
            System.out.println(message);
            String value = scanner.nextLine().trim();
            if (value.equalsIgnoreCase("U") || value.equalsIgnoreCase("D")) {
                return value;
            } else {
                System.out.println("Please input U or D.");
            }
        }
    }
}