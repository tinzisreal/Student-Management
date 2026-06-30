/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

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
                    System.err.println(err);
                }
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng! Vui lòng nhập số nguyên.");
            }
        }
        return result;
    }

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
                    System.err.println(err);
                }
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng! Vui lòng nhập số thực.");
            }
        }
        return result;
    }

    public static String getInputString(String msg, String err) {

       String str = "";
       while (str.isEmpty()) {
           System.out.println(msg);
           str = scanner.nextLine().trim();

           if (str.isEmpty()) {
               System.out.println(err);
           }
       }

       return str;
   }

    public static boolean getInputYOrN() {
        String str = "";

        while (!str.equalsIgnoreCase("Y")
                && !str.equalsIgnoreCase("N")) {

            System.out.print("Please input Y or N: ");
            str = scanner.nextLine().trim();

            if (!str.equalsIgnoreCase("Y")
                    && !str.equalsIgnoreCase("N")) {
                System.out.println("Invalid input.");
            }
        }

        return str.equalsIgnoreCase("Y");
    }
    
    
    public static boolean getInputYOrn(){
        String str="";
        
        while(!str.equalsIgnoreCase("Y")&&!str.equalsIgnoreCase("N")){
            System.out.println("please");
            
            str = scanner.nextLine().trim();
            if(!str.equalsIgnoreCase("Y")&&!str.equalsIgnoreCase("N")){
                System.out.println("Invalid");
            }
        }
        return str.equalsIgnoreCase("Y");
    }
}
