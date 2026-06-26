package entity;

public class Education {
    private String uniName;
    private int graduationDate;
    private String rank;

    public Education() {
    }

    public Education(String uniName, int graduationDate, String rank) {
        this.uniName = uniName;
        this.graduationDate = graduationDate;
        this.rank = rank;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return uniName + " (" + graduationDate + ", " + rank + ")";
    }
}
