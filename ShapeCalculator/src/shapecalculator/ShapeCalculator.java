package shapecalculator;

import entity.Circle;
import entity.Retangle;
import entity.Triangle;
import java.util.Scanner;
import utils.utils;

public class ShapeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====Calculator Shape Program=====");

        // Input Rectangle
        double width = utils.getInputPositiveDouble(sc, "Please input side width of Rectangle:\n");
        double length = utils.getInputPositiveDouble(sc, "Please input length of Rectangle:\n");
        Retangle rectangle = new Retangle(width, length);

        // Input Circle
        double radius = utils.getInputPositiveDouble(sc, "Please input radius of Circle:\n");
        Circle circle = new Circle(radius);

        // Input Triangle
        double sideA, sideB, sideC;
        while (true) {
            sideA = utils.getInputPositiveDouble(sc, "Please input side A of Triangle:\n");
            sideB = utils.getInputPositiveDouble(sc, "Please input side B of Triangle:\n");
            sideC = utils.getInputPositiveDouble(sc, "Please input side C of Triangle:\n");
            if (utils.isValidTriangle(sideA, sideB, sideC)) {
                break;
            } else {
                System.out.println("Invalid triangle! Please enter again.");
            }
        }
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        // Display results
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
