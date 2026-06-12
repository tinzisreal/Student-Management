import bo.StudentManager;
import utils.Validation;

public class Main {

    // 1. Phương thức khởi chạy chính
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        int choice = 0;

        do {
            displayMenu();
            choice = Validation.checkIntegerInRange("Lựa chọn của bạn: ", 
                    "Vui lòng chọn từ 1 đến 5!", 1, 5);
            
            switch (choice) {
                case 1: 
                    manager.createStudent(); 
                    break;
                case 2: 
                    manager.findAndSortStudents(); 
                    break;
                case 3: 
                    manager.updateOrDeleteStudent(); 
                    break;
                case 4: 
                    manager.report(); 
                    break;
                case 5: 
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                    break;
            }
        } while (choice != 5);
    }

    // 2. Helper hiển thị giao diện Menu chính
    private static void displayMenu() {
        System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }
}
