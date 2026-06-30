package Test.utils;

import java.util.Comparator;
import Test.model.Student;

public class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getStudentName().compareTo(s2.getStudentName());
    }
}
