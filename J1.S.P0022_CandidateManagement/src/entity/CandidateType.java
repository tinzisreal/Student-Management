package entity;

public enum CandidateType {
    EXPERIENCE(0, "Experience"),
    FRESHER(1, "Fresher"),
    INTERN(2, "Intern");

    private final int value;
    private final String label;

    CandidateType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static CandidateType fromValue(int value) {
        for (CandidateType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Candidate Type: " + value);
    }
}
