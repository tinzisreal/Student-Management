package entity;

public class Intern extends Candidate {
    private String majors;
    private int semester;
    private String universityName;

    public Intern() {
        super();
        setType(CandidateType.INTERN);
    }

    public Intern(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, String majors, int semester, String universityName) {
        super(id, firstName, lastName, birthDate, address, phone, email, CandidateType.INTERN);
        this.majors = majors;
        this.semester = semester;
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

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
