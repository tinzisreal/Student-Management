package bo;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import utils.Validation;

import java.util.ArrayList;

public class CandidateManager {

    private ArrayList<Candidate> candidates;

    public CandidateManager() {
        candidates = new ArrayList<>();
        // Add some dummy data for testing if needed
    }

    public void createCandidate(int type) {
        do {
            String id = Validation.getInputString("Enter id: ", "Id cannot be empty!");
            String firstName = Validation.getInputString("Enter first name: ", "First name cannot be empty!");
            String lastName = Validation.getInputString("Enter last name: ", "Last name cannot be empty!");
            int birthDate = Validation.checkBirthDate("Enter birth date: ");
            String address = Validation.getInputString("Enter address: ", "Address cannot be empty!");
            String phone = Validation.checkPhone("Enter phone: ");
            String email = Validation.checkEmail("Enter email: ");

            Candidate candidate = null;

            switch (type) {
                case 0:
                    int expInYear = Validation.checkExpInYear("Enter year of experience: ");
                    String proSkill = Validation.getInputString("Enter professional skill: ", "Professional skill cannot be empty!");
                    candidate = new Experience(id, firstName, lastName, birthDate, address, phone, email, expInYear, proSkill);
                    break;
                case 1:
                    int graduationDate = Validation.checkIntegerInRange("Enter graduation date: ", "Must be a valid year", 1900, 2100);
                    String graduationRank = Validation.checkGraduationRank("Enter graduation rank (Excellence, Good, Fair, Poor): ");
                    String education = Validation.getInputString("Enter university where student graduated: ", "Cannot be empty!");
                    candidate = new Fresher(id, firstName, lastName, birthDate, address, phone, email, graduationDate, graduationRank, education);
                    break;
                case 2:
                    String majors = Validation.getInputString("Enter majors: ", "Cannot be empty!");
                    int semester = Validation.checkIntegerInRange("Enter semester: ", "Semester must be a valid number", 1, 10);
                    String universityName = Validation.getInputString("Enter university name: ", "Cannot be empty!");
                    candidate = new Intern(id, firstName, lastName, birthDate, address, phone, email, majors, semester, universityName);
                    break;
            }

            if (candidate != null) {
                candidates.add(candidate);
                System.out.println("Created successfully.");
            }

        } while (Validation.getInputYOrN());

        System.out.println("\nCandidates created:");
        for (Candidate c : candidates) {
            System.out.println(c.toString());
        }
    }

    public void searchCandidate() {
        displayAllCandidates();

        String nameSearch = Validation.getInputString("Input Candidate name (First name or Last name): ", "Cannot be empty!");
        int typeSearch = Validation.checkIntegerInRange("Input type of candidate: ", "Must be 0, 1, or 2", 0, 2);

        System.out.println("\nThe candidates found:");
        for (Candidate c : candidates) {
            if (c.getType() == typeSearch && 
                (c.getFirstName().toLowerCase().contains(nameSearch.toLowerCase()) || 
                 c.getLastName().toLowerCase().contains(nameSearch.toLowerCase()))) {
                System.out.println(c.toString());
            }
        }
    }

    private void displayAllCandidates() {
        System.out.println("List of candidate:");
        
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate c : candidates) {
            if (c.getType() == 0) {
                System.out.println(c.getFullName());
            }
        }

        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate c : candidates) {
            if (c.getType() == 1) {
                System.out.println(c.getFullName());
            }
        }

        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate c : candidates) {
            if (c.getType() == 2) {
                System.out.println(c.getFullName());
            }
        }
    }
}
