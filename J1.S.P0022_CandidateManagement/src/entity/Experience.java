package entity;

import java.util.List;

public class Experience extends Candidate {
    private List<ProSkill> proSkills;

    public Experience() {
        super();
        setType(CandidateType.EXPERIENCE);
    }

    public Experience(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, List<ProSkill> proSkills) {
        super(id, firstName, lastName, birthDate, address, phone, email, CandidateType.EXPERIENCE);
        this.proSkills = proSkills;
    }

    public List<ProSkill> getProSkills() {
        return proSkills;
    }

    public void setProSkills(List<ProSkill> proSkills) {
        this.proSkills = proSkills;
    }
}
