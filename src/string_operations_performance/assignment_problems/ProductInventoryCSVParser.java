package string_operations_performance.assignment_problems;

import java.util.Scanner;

public class ProductInventoryCSVParser {

    static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0].trim()
                + " | SKU: " + fields[1].trim()
                + " | Qty: " + fields[2].trim());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter inventory record: ");
        String csvLine = scanner.nextLine();

        parseInventoryRecord(csvLine);

        scanner.close();
    }
}