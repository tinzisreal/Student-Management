import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    static class Student {
        String id;
        String name;
        String course;

        public Student(String id, String name, String course) {
            this.id = id;
            this.name = name;
            this.course = course;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        System.out.println("--- Thêm dữ liệu sinh viên ---");
        // Thêm Nguyễn Văn A, môn JAVA
        students.add(new Student("1", "Nguyen Van A", "JAVA"));
        System.out.println("Thêm: Nguyễn Văn A học JAVA");
        
        // Thêm Nguyễn Văn A, môn JAVA (đăng ký lại, kỳ khác)
        students.add(new Student("1", "Nguyen Van A", "JAVA"));
        System.out.println("Thêm: Nguyễn Văn A học JAVA");

        // Thêm Nguyễn Văn A, môn .Net
        students.add(new Student("1", "Nguyen Van A", ".NET"));
        System.out.println("Thêm: Nguyễn Văn A học .NET");

        // Thêm Lê Thị B, môn C/C++
        students.add(new Student("2", "Le Thi B", "C/C++"));
        System.out.println("Thêm: Lê Thị B học C/C++");

        System.out.println("\n--- Bắt đầu chạy hàm Report ---");
        Map<String, Integer> reportMap = new LinkedHashMap<>();
        
        System.out.println("Quá trình tính toán Total trong vòng lặp:");
        for (Student student : students) {
            String key = student.name + "|" + student.course;
            int totalHienTai = reportMap.getOrDefault(key, 0);
            int totalMoi = totalHienTai + 1;
            reportMap.put(key, totalMoi);
            
            System.out.println(" -> Đang xét sinh viên: " + key);
            System.out.println("    Total hiện tại trong Map: " + totalHienTai + " => Cộng thêm 1 thành: " + totalMoi);
        }

        System.out.println("\n--- Kết quả hiển thị (như trong StudentController) ---");
        System.out.println("Student Name | Course | Total");
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            String[] parts = entry.getKey().split("\\|");
            System.out.println(parts[0] + " | " + parts[1] + " | " + entry.getValue());
        }
    }
}
