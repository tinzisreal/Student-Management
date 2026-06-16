package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    // Nhập số nguyên dương
    private static int getPositiveInteger(Scanner sc, String message) {
        int number;

        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                number = sc.nextInt();

                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Must be a positive integer.");
                }
            } else {
                System.out.println("Invalid input, must be an integer.");
                sc.next();
            }
        }
    }

    // Nhập số nguyên bất kỳ
    private static int getInteger(Scanner sc, String message) {
        int number;

        while (true) {
            System.out.print(message);

            if (sc.hasNextInt()) {
                number = sc.nextInt();
                return number;
            } else {
                System.out.println("Invalid input, must be an integer.");
                sc.next();
            }
        }
    }

    // Tạo mảng random
    public static int[] generateRandomArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(10); // random từ 0 -> 9
        }

        return arr;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int searchValue) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == searchValue) {
                return mid;
            }

            if (arr[mid] < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = getPositiveInteger(sc, "Enter number of array: ");

        // Cho phép nhập cả số âm và 0
        int searchValue = getInteger(sc, "Enter search value: ");

        // Tạo mảng
        int[] arr = generateRandomArray(size);

        // Sắp xếp mảng
        Arrays.sort(arr);

        // In mảng
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Tìm kiếm
        int index = binarySearch(arr, searchValue);

        // Kết quả
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println(searchValue + " not found.");
        }

        sc.close();
    }
}