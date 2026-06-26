package entity;

import java.util.List;

public class Intern extends Candidate {
    private List<University> universities;

    public Intern() {
        super();
        setType(CandidateType.INTERN);
    }

    public Intern(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, List<University> universities) {
        super(id, firstName, lastName, birthDate, address, phone, email, CandidateType.INTERN);
        this.universities = universities;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }
}
