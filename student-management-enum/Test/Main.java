package Test;

import Test.model.Course;
import Test.model.Student;
import Test.service.StudentService;
import Test.controller.StudentController;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        System.out.println("--- Thêm dữ liệu sinh viên ---");
        // Thêm Nguyễn Văn A, môn JAVA
        service.createStudent(new Student("1", "Nguyen Van A", "Fall2023", Course.JAVA));
        System.out.println("Thêm: Nguyễn Văn A | JAVA");
        
        // Thêm Nguyễn Văn A, môn JAVA (khác kỳ học) -> Vẫn là 1 khóa học JAVA của A
        service.createStudent(new Student("1", "Nguyen Van A", "Spring2024", Course.JAVA));
        System.out.println("Thêm: Nguyễn Văn A | JAVA");

        // Thêm Nguyễn Văn A, môn .Net
        service.createStudent(new Student("1", "Nguyen Van A", "Summer2024", Course.DOT_NET));
        System.out.println("Thêm: Nguyễn Văn A | .NET");

        // Thêm Lê Thị B, môn C/C++
        service.createStudent(new Student("2", "Le Thi B", "Fall2023", Course.C_PP));
        System.out.println("Thêm: Lê Thị B | C/C++");

        System.out.println("\n--- Bắt đầu chạy Report ---");
        Map<String, Integer> report = service.report();
        System.out.println("Student Name | Course | Total");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            String[] parts = entry.getKey().split("\\|");
            System.out.println(parts[0] + " | " + parts[1] + " | " + entry.getValue());
        }
    }
}
