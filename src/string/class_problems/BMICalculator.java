package string.class_problems;

import java.util.Random;

public class BMICalculator {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("\n================ WELLNESS REPORT ================");
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        System.out.println("--------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s %-12.2f %-12.2f %-10.2f %-15s%n",
                    "Person " + (i + 1),
                    heights[i],
                    weights[i],
                    bmi,
                    status);
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        int teamSize = 10;

        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        // Generate random height and weight values
        for (int i = 0; i < teamSize; i++) {

            heights[i] = 1.50 + (1.90 - 1.50) * random.nextDouble();
            weights[i] = 45 + (100 - 45) * random.nextDouble();
        }

        printWellnessReport(heights, weights);
    }
}