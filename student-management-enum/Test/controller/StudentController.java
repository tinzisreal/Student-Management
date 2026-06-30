package Test.controller;

import java.util.Scanner;

import Test.service.StudentService;
import Test.utils.InputValidator;
import com.tung.studentmanagement.view.StudentMenu;
import Test.model.Course;
import Test.model.Student;
import java.util.List;
import java.util.Map;
public class StudentController {
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator validator = new InputValidator(scanner);
    private final StudentService studentService = new StudentService();
    private final StudentMenu menu = new StudentMenu();

    public void run() {
        while (true) {
            menu.showMainMenu();
            int choice = validator.inputInt("Please choose: ", 1, 5);
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSortStudents();
                    break;
                case 3:
                    updateOrDeleteStudent();
                    break;
                case 4:
                    reportStudents();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    break;
            }
        }
    }

    private void createStudent() {
        String id = validator.inputNonEmpty("Input id: ");
        String name = validator.inputNonEmpty("Input name: ");
        String semester = validator.inputNonEmpty("Input semester: ");
        Course course = validator.inputCourse("Input course: ");

        if (studentService.createStudent(new Student(id, name, semester, course))) {
            System.out.println("Success add student");
            if (studentService.getStudentCount() >= 10) {
                String answer = validator.inputYesNo("Do you want to continue (Y/N)? ");
                if (answer.equalsIgnoreCase("N")) {
                    return;
                }
            }
        } else {
            System.out.println("Student already exists");
        }

    }

    private void findAndSortStudents() {
        String keyword = validator.inputNonEmpty("Input student name to search: ");
        List<Student> students = studentService.findAndSortByName(keyword);
        if (students.isEmpty()) {
            System.out.println("No student found.");
            return;
        }
        menu.showStudentHeader();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateOrDeleteStudent() {
        String id = validator.inputNotEmpty("Input id: ");
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        String choice = validator.inputUpdateDelete("Input U or D: ");
        if (choice.equalsIgnoreCase("U")) {
            String name = validator.inputNonEmpty("Input name: ");
            String semester = validator.inputNonEmpty("Input semester: ");
            Course course = validator.inputCourse("Input course: ");
            if (studentService.updateStudent(id, name, semester, course)) {
                System.out.println("Success update student");
            } else {
                System.out.println("Student not found.");
                break;
            }
        } else if (choice.equalsIgnoreCase("D")) {
            if (studentService.deleteStudent(id)) {
                System.out.println("Success delete student");
            } else {
                System.out.println("Student not found.");
                break;
            }
        }
    }

    private void reportStudents() {
        Map<String, Integer> report = studentService.report();
        if (report.isEmpty()) {
            System.out.println("No data to report.");
            return;
        }

        System.out.println("Student Name | Course | Total");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            String[] parts = entry.getKey().split("\\|");
            System.out.println(parts[0] + " | " + parts[1] + " | " + entry.getValue());
        }
    }
}
