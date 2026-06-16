package linearsearch;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    private static int getPositiveInt(Scanner sc, String message) {
        int n;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();
            }
        }
    }

    private static int[] generateRandomArray(int size, int min, int max) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        System.out.print("The array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = getPositiveInt(sc, "Enter number of array: ");
        int[] arr = generateRandomArray(size, 1, 9);

        System.out.print("Enter search value: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter search value again: ");
            sc.next();
        }
        int target = sc.nextInt();

        printArray(arr);

        int index = linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println(target + " not found in array.");
        }

        sc.close();
    }
}