package main;

import bo.NormalizeText;
import utils.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            System.out.println("Reading from " + inputFile + "...");
            List<String> lines = FileHandler.readFile(inputFile);

            System.out.println("Normalizing text...");
            List<String> normalizedLines = NormalizeText.normalize(lines);

            System.out.println("Writing to " + outputFile + "...");
            FileHandler.writeFile(outputFile, normalizedLines);

            System.out.println("Normalization successful. Check " + outputFile + " for the result.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Please make sure " + inputFile + " exists in the project root.");
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
