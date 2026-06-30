package Test.model;

public class Student {
    private String id;
    private String studentName;
    private String semester;
    private Course course;

    public Student(String id, String studentName, String semester, Course course) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.course = course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
