package entity;

public enum Course {
    JAVA("Java"),
    DOT_NET(".Net"),
    C_CPP("C/C++");

    private final String value;

    Course(String value) {
        this.value = value;
    }

    public static Course fromChoice(int choice) {
        switch (choice) {
            case 1:
                return JAVA;
            case 2:
                return DOT_NET;
            case 3:
                return C_CPP;
            default:
                throw new IllegalArgumentException("Invalid course choice.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
