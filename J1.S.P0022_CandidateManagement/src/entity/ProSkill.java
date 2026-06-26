package entity;

public class ProSkill {
    private int expInYear;
    private String skillName;

    public ProSkill() {
    }

    public ProSkill(int expInYear, String skillName) {
        this.expInYear = expInYear;
        this.skillName = skillName;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return skillName + " (" + expInYear + " years)";
    }
}
