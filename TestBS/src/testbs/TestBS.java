/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testbs;

/**
 *
 * @author lenovo
 */
public class TestBS {

    private static int binarySearch(int[] arr, int searchValue) {
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
                mid = right - 1;
            }

        }

        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
