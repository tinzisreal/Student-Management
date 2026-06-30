package Test.model;

public enum Course {
    JAVA("JAVA"),
    C_PP("C/C++"),
    DOT_NET(".Net");

    private String value;

    Course(String value) {
        this.value = value;
    }

    public static Course fromChoice(int choice) {
        while (true) {
            switch (choice) {
                case 1:
                    return JAVA;
                case 2:
                    return C_PP;
                case 3:
                    return DOT_NET;
                default:
                    throw new IllegalArgumentException("Invalid course choice.");
            }
        }
    }

}