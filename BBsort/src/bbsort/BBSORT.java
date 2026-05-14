package bbsort;

import java.util.Random;
import java.util.Scanner;

public class BBSORT {

    private static int getInputPositiveInteger(Scanner sc, String message) {
        int number;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Must be a positive integer, please enter again.");
                }
            } else {
                System.out.println("Invalid input, must be an integer.");
                sc.next(); // bỏ token sai để tránh lặp vô hạn
            }
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] generateRandomArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(10);
        }
        return arr;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = getInputPositiveInteger(sc, "Enter positive integer: ");

        int[] arr = generateRandomArray(size);

        System.out.println("Before sort:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("After sort:");
        printArray(arr);

        sc.close();
    }
}