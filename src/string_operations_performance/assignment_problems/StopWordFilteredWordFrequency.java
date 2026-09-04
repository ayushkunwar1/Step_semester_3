package string_operations_performance.assignment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback.toLowerCase();

        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                frequency.put(
                        word,
                        frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        // Print words in descending frequency order
        while (!frequency.isEmpty()) {

            String highestWord = null;
            int highestCount = -1;

            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {

                if (entry.getValue() > highestCount) {
                    highestWord = entry.getKey();
                    highestCount = entry.getValue();
                }
            }

            System.out.println(highestWord + ": " + highestCount);

            frequency.remove(highestWord);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
