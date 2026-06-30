package utils;

import java.util.Scanner;

public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    // 1. Nhập số nguyên trong khoảng [min, max]
    public static int checkIntegerInRange(String msg, String err, int min, int max) {
        int result = 0;
        boolean isValid = false;
        
        while (!isValid) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(scanner.nextLine().trim());
                if (result >= min && result <= max) {
                    isValid = true;
                } else {
                    System.out.println(err);
                }
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng! Vui lòng nhập số nguyên.");
            }
        }
        return result;
    }

    // 2. Nhập số thực trong khoảng [min, max]
    public static double checkDoubleInRange(String msg, String err, double min, double max) {
        double result = 0;
        boolean isValid = false;
        
        while (!isValid) {
            try {
                System.out.print(msg);
                result = Double.parseDouble(scanner.nextLine().trim());
                if (result >= min && result <= max) {
                    isValid = true;
                } else {
                    System.out.println(err);
                }
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng! Vui lòng nhập số thực.");
            }
        }
        return result;
    }

    // 3. Nhập chuỗi ký tự, bắt buộc không được để trống
    public static String getInputString(String msg, String err) {
       String str = "";
       while (str.isEmpty()) {
           System.out.print(msg);
           str = scanner.nextLine().trim();
           if (str.isEmpty()) {
               System.out.println(err);
           }
       }
       return str;
   }

    // 4. Nhập lựa chọn Y/N (Đã sửa lỗi hiển thị thông báo sai khi nhập N)
    public static boolean getInputYOrN() {
        String str = "";
        boolean isValid = false;
        
        while (!isValid) {
            System.out.print("Please input Y or N: ");
            str = scanner.nextLine().trim();
            if (str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("N")) {
                isValid = true;
            } else {
                System.out.println("Invalid input.");
            }
        }
        return str.equalsIgnoreCase("Y");
    }
}
