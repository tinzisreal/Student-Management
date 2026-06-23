package entity;

public class Enrollment {
    private String semester;
    private Course course;

    public Enrollment() {
    }

    public Enrollment(String semester, Course course) {
        this.semester = semester;
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return semester + " | " + course;
    }
}
