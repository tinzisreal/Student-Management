package entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String studentName;
    private List<Enrollment> enrollments;

    public Student() {
        this.enrollments = new ArrayList<>();
    }

    public Student(String id, String studentName) {
        this.id = id;
        this.studentName = studentName;
        this.enrollments = new ArrayList<>();
    }

    public Student(String id, String studentName, String semester, Course course) {
        this.id = id;
        this.studentName = studentName;
        this.enrollments = new ArrayList<>();
        this.enrollments.add(new Enrollment(semester, course));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addEnrollment(String semester, Course course) {
        this.enrollments.add(new Enrollment(semester, course));
    }

    public String toString(Enrollment enrollment) {
        return String.format("%-10s | %-20s | %-10s | %-10s", id, studentName, enrollment.getSemester(), enrollment.getCourse());
    }

    @Override
    public String toString() {
        if (enrollments.isEmpty()) {
            return String.format("%-10s | %-20s | %-10s | %-10s", id, studentName, "", "");
        }
        Enrollment first = enrollments.get(0);
        return toString(first);
    }
}
