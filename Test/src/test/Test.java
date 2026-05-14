/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class Test {

    public static int getInputPositiveInteger(Scanner sc, String message) {
        int number;

        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Must be positive integer");
                }
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void printArray(int[] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
            if (i < arr.length - 1) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }

    public static int[] generateRandomArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(10);
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // nếu không swap lần nào -> mảng đã sort
            if (!swapped) {
                break;
            }
        }
    }

    public static void bBSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    temp = arr[j + 1];

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          Scanner sc = new Scanner(System.in);

        int size = getInputPositiveInteger(sc, "Enter number of array: ");

        int[] arr = generateRandomArray(size);

        System.out.print("Unsorted array: ");
        printArray(arr);

        bubbleSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);
    }

}
