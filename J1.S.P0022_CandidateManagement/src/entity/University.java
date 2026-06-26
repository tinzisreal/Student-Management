package entity;

public class University {
    private String universityName;
    private String majors;
    private int semester;

    public University() {
    }

    public University(String universityName, String majors, int semester) {
        this.universityName = universityName;
        this.majors = majors;
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return universityName + " - " + majors + " (Semester: " + semester + ")";
    }
}
