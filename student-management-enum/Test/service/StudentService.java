package Test.service;

import Test.model.Student;
import Test.model.Course;
import Test.utils.StudentComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class StudentService {
    private List<Student> students = new ArrayList<>();

    public int getStudentCount() {
        return students.size();
    }

    public boolean createStudent(Student student) {
        for (Student existingStudent : students) {
            if (existingStudent.getId().equalsIgnoreCase(student.getId())
                    && existingStudent.getSemester().equalsIgnoreCase(student.getSemester())
                    && existingStudent.getCourse() == student.getCourse()) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public List<Student> findAndSortByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(student);
            }
        }
        Collections.sort(result, new StudentComparator());
        return result;
    }

    public Student findById(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(String id, String newName, String newSemester, Course newCourse) {
        Student student = findById(id);
        if (student == null) {
            return false;
        }
        student.setStudentName(newName);
        student.setSemester(newSemester);
        student.setCourse(newCourse);
        return true;
    }

    public boolean deleteStudent(String id) {
        Student student = findById(id);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }

    public Map<String, Integer> report() {
        Map<String, Integer> reportMap = new LinkedHashMap<>();
        for (Student student : students) {
            String key = student.getStudentName() + "|" + student.getCourse();
            reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
        }
        return reportMap;
    }

}
