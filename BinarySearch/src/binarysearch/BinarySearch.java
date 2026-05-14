/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class BinarySearch {

    // Hàm nhập số nguyên dương
    public static int inputPositiveNumber(Scanner sc, String message) {

        int number;

        while (true) {

            try {

                System.out.print(message);

                number = Integer.parseInt(sc.nextLine());

                if (number > 0) {
                    return number;
                }

                System.out.println("Please enter a positive number.");

            } catch (Exception e) {

                System.out.println("Invalid input.");
            }
        }
    }

    // Hàm tạo mảng random
    public static int[] generateRandomArray(int size) {

        Random rd = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(10); // random từ 0 -> 9
        }

        return arr;
    }

    // Hàm in mảng
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

    // Hàm binary search
    public static int binarySearch(int[] arr, int searchValue) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = inputPositiveNumber(sc, "Enter number of array: ");

        int searchValue = inputPositiveNumber(sc, "Enter search value: ");

        int[] arr = generateRandomArray(size);

        // sort array
        Arrays.sort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);

        // binary search
        int index = binarySearch(arr, searchValue);

        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println(searchValue + " not found.");
        }
    }

}