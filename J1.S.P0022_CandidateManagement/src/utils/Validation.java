package utils;

import java.util.Calendar;
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

    // 2. Nhập chuỗi ký tự, bắt buộc không được để trống
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

    // 3. Nhập lựa chọn Y/N
    public static boolean getInputYOrN() {
        String str = "";
        boolean isValid = false;
        
        while (!isValid) {
            System.out.print("Do you want to continue (Y/N)? ");
            str = scanner.nextLine().trim();
            if (str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("N")) {
                isValid = true;
            } else {
                System.out.println("Invalid input.");
            }
        }
        return str.equalsIgnoreCase("Y");
    }

    // 4. Nhập năm sinh 4 chữ số (1900..Current Year)
    public static int checkBirthDate(String msg) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return checkIntegerInRange(msg, "Birth date must be between 1900 and " + currentYear, 1900, currentYear);
    }

    // 5. Nhập số điện thoại (ít nhất 10 số)
    public static String checkPhone(String msg) {
        String phone = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(msg);
            phone = scanner.nextLine().trim();
            if (phone.matches("\\d{10,}")) {
                isValid = true;
            } else {
                System.out.println("Phone must be at least 10 digits.");
            }
        }
        return phone;
    }

    // 6. Nhập email format <account name>@<domain>
    public static String checkEmail(String msg) {
        String email = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(msg);
            email = scanner.nextLine().trim();
            if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                isValid = true;
            } else {
                System.out.println("Email must be in format <account name>@<domain>");
            }
        }
        return email;
    }

    // 7. Nhập rank of graduation (Excellence, Good, Fair, Poor)
    public static String checkGraduationRank(String msg) {
        String rank = "";
        boolean isValid = false;
        while (!isValid) {
            rank = getInputString(msg, "Rank cannot be empty");
            if (rank.equalsIgnoreCase("Excellence") || rank.equalsIgnoreCase("Good") 
                    || rank.equalsIgnoreCase("Fair") || rank.equalsIgnoreCase("Poor")) {
                isValid = true;
            } else {
                System.out.println("Rank must be one of (Excellence, Good, Fair, Poor)");
            }
        }
        return rank;
    }

    // 8. Nhập năm kinh nghiệm (0..100)
    public static int checkExpInYear(String msg) {
        return checkIntegerInRange(msg, "Experience year must be between 0 and 100", 0, 100);
    }
}
