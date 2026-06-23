import bo.CandidateManager;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        CandidateManager manager = new CandidateManager();

        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");

            int choice = Validation.checkIntegerInRange("Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program: ", "Must be between 1 and 5", 1, 5);

            switch (choice) {
                case 1:
                    manager.createCandidate(0);
                    break;
                case 2:
                    manager.createCandidate(1);
                    break;
                case 3:
                    manager.createCandidate(2);
                    break;
                case 4:
                    manager.searchCandidate();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
