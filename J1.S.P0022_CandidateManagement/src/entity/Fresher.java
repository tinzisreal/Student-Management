package entity;

import java.util.List;

public class Fresher extends Candidate {
    private List<Education> educations;

    public Fresher() {
        super();
        setType(CandidateType.FRESHER);
    }

    public Fresher(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, List<Education> educations) {
        super(id, firstName, lastName, birthDate, address, phone, email, CandidateType.FRESHER);
        this.educations = educations;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }
}
