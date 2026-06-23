package bo;

import entity.Course;
import entity.Student;
import entity.Enrollment;
import utils.Validation;
import utils.StudentComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class StudentManager {

    private final List<Student> studentList = new ArrayList<>();

    // Constructor khởi tạo sẵn dữ liệu mẫu
    public StudentManager() {
        Student s1 = new Student("1", "Nguyen Van A");
        s1.addEnrollment("HK1", Course.JAVA);
        s1.addEnrollment("HK2", Course.DOT_NET);
        studentList.add(s1);

        Student s2 = new Student("2", "Tran Thi B");
        s2.addEnrollment("HK1", Course.DOT_NET);
        studentList.add(s2);

        Student s3 = new Student("3", "Le Van C");
        s3.addEnrollment("HK2", Course.C_CPP);
        studentList.add(s3);
    }

    // 1. Chức năng 1: Tạo sinh viên (Create Student)
    public void createStudent() {
        do {
            String id = Validation.getInputString("Nhập mã sinh viên (Student ID): ", "Mã sinh viên không được rỗng!");
            
            // Tìm xem ID này đã tồn tại trong hệ thống chưa
            String name = "";
            Student existingStudent = getStudentById(id);
            if (existingStudent != null) {
                name = existingStudent.getStudentName();
                System.out.println("Sinh viên đã tồn tại trong hệ thống (Tên: " + name + ")");
            } else {
                name = Validation.getInputString("Nhập tên sinh viên: ", "Tên sinh viên không được rỗng!");
            }

            String semester = Validation.getInputString("Nhập học kỳ (Semester): ", "Học kỳ không được rỗng!");
            Course course = Validation.checkCourseInput("Chọn khóa học:");

            // Kiểm tra trùng lặp bản ghi (ID, học kỳ, khóa học)
            if (checkDuplicate(id, semester, course)) {
                System.out.println("Lỗi: Bản ghi đã tồn tại (Sinh viên này đã học môn này trong học kỳ này)!");
                
                // In thông báo trước khi nhảy xuống điều kiện while bằng lệnh continue
                if (studentList.size() <= 10) {
                    System.out.println("Hiện có " + studentList.size() + " sinh viên. Tiếp tục nhập để đạt trên 10 sinh viên.");
                } else {
                    System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                }
                continue;
            }
            
            if (existingStudent != null) {
                existingStudent.addEnrollment(semester, course);
            } else {
                Student newStudent = new Student(id, name);
                newStudent.addEnrollment(semester, course);
                studentList.add(newStudent);
            }
            System.out.println("Thêm sinh viên thành công.");

            // In thông báo nếu cần hỏi Y/N
            if (studentList.size() <= 10) {
                System.out.println("Hiện có " + studentList.size() + " sinh viên. Tiếp tục nhập để đạt trên 10 sinh viên.");
            } else {
                System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
            }
        } while (studentList.size() <= 10 || Validation.getInputYOrN());
    }

    // 2. Chức năng 2: Tìm kiếm và Sắp xếp (Find and Sort)
    public void findAndSortStudents() {
        String keyword = Validation.getInputString("Nhập tên sinh viên cần tìm (hoặc một phần tên): ", "Từ khóa không được rỗng!");
        List<Student> results = new ArrayList<>();
        
        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào phù hợp.");
            return;
        }

        // Sắp xếp tăng dần theo tên bằng StudentComparator
        Collections.sort(results, new StudentComparator());

        displayHeader();
        for (Student student : results) {
            for (Enrollment enrollment : student.getEnrollments()) {
                System.out.println(student.toString(enrollment));
            }
        }
    }

    // 3. Chức năng 3: Cập nhật hoặc Xóa sinh viên (Update/Delete)
    public void updateOrDeleteStudent() {
        String id = Validation.getInputString("Nhập mã sinh viên cần sửa/xóa: ", "Mã sinh viên không được rỗng!");
        Student student = getStudentById(id);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên với mã ID đã cho.");
            return;
        }

        List<Enrollment> enrollments = student.getEnrollments();
        if (enrollments.isEmpty()) {
            System.out.println("Sinh viên không có bản ghi đăng ký nào.");
            return;
        }

        boolean isUpdate = Validation.checkUpdateDelete("Bạn muốn cập nhật (U) hay xóa (D) sinh viên này: ");
        if (isUpdate) {
            Enrollment enrollmentToUpdate;
            if (enrollments.size() == 1) {
                enrollmentToUpdate = enrollments.get(0);
            } else {
                System.out.println("Tìm thấy nhiều bản ghi của sinh viên này:");
                for (int i = 0; i < enrollments.size(); i++) {
                    System.out.println((i + 1) + ". " + student.toString(enrollments.get(i)));
                }
                int index = Validation.checkIntegerInRange("Chọn bản ghi muốn cập nhật (theo STT): ", 
                        "Vui lòng chọn đúng STT có trên màn hình!", 1, enrollments.size());
                enrollmentToUpdate = enrollments.get(index - 1);
            }

            String newName = Validation.getInputString("Nhập tên mới: ", "Tên không được rỗng!");
            String newSemester = Validation.getInputString("Nhập học kỳ mới: ", "Học kỳ không được rỗng!");
            Course newCourse = Validation.checkCourseInput("Chọn khóa học mới:");

            // Kiểm tra trùng lặp khóa học trong học kỳ đối với bản ghi khác của cùng sinh viên
            boolean isDuplicate = false;
            for (Enrollment e : enrollments) {
                if (e != enrollmentToUpdate && 
                    e.getSemester().equalsIgnoreCase(newSemester) && 
                    e.getCourse() == newCourse) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Cập nhật thất bại! Sinh viên đã học môn này trong học kỳ này.");
            } else {
                // Cập nhật tên mới cho toàn bộ sinh viên
                student.setStudentName(newName);
                enrollmentToUpdate.setSemester(newSemester);
                enrollmentToUpdate.setCourse(newCourse);
                System.out.println("Cập nhật thành công.");
            }
        } else {
            // Delete action
            Enrollment enrollmentToDelete;
            if (enrollments.size() == 1) {
                enrollmentToDelete = enrollments.get(0);
            } else {
                System.out.println("Tìm thấy nhiều bản ghi của sinh viên này:");
                for (int i = 0; i < enrollments.size(); i++) {
                    System.out.println((i + 1) + ". " + student.toString(enrollments.get(i)));
                }
                int index = Validation.checkIntegerInRange("Chọn bản ghi muốn xóa (theo STT): ", 
                        "Vui lòng chọn đúng STT có trên màn hình!", 1, enrollments.size());
                enrollmentToDelete = enrollments.get(index - 1);
            }
            enrollments.remove(enrollmentToDelete);
            
            // Nếu không còn lượt học nào, xóa sinh viên khỏi danh sách chính
            if (enrollments.isEmpty()) {
                studentList.remove(student);
            }
            System.out.println("Xóa thành công.");
        }
    }

    // 4. Chức năng 4: Báo cáo (Report)
    public void report() {
        if (studentList.isEmpty()) {
            System.out.println("Không có sinh viên nào trong danh sách.");
            return;
        }

        Map<String, Integer> reportMap = new LinkedHashMap<>();
        for (Student student : studentList) {
            for (Enrollment enrollment : student.getEnrollments()) {
                String key = student.getId() + "|" + student.getStudentName() + "|" + enrollment.getCourse();
                reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
            }
        }

        System.out.println("\n=== BÁO CÁO KHÓA HỌC SINH VIÊN ===");
        System.out.printf("%-20s | %-10s | %-5s\n", "Student Name", "Course", "Total");
        System.out.println("-----------------------------------------");
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            String[] parts = entry.getKey().split("\\|");
            System.out.printf("%-20s | %-10s | %-5d\n", parts[1], parts[2], entry.getValue());
        }
    }

    // Helper: Lấy sinh viên theo ID (trả về đối tượng đầu tiên khớp ID)
    private Student getStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    // Helper: Kiểm tra trùng lặp bản ghi
    private boolean checkDuplicate(String id, String semester, Course course) {
        Student s = getStudentById(id);
        if (s != null) {
            for (Enrollment e : s.getEnrollments()) {
                if (e.getSemester().equalsIgnoreCase(semester) && e.getCourse() == course) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper hiển thị tiêu đề bảng sinh viên
    private void displayHeader() {
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "ID", "Student Name", "Semester", "Course");
        System.out.println("-----------------------------------------------------------------");
    }
}
