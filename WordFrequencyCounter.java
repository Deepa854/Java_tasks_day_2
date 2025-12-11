// Count the frequency of each word in a paragraph using HashMap.

package java_assessment_day2;

import java.util.HashMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        // Step 1: Input paragraph
        String paragraph = "Java is fun and Java is powerful and fun";

        // Step 2: Split paragraph into words using space
        String[] words = paragraph.split(" ");

        // Step 3: Create HashMap to store word counts
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Step 4: Loop through each word
        for (String word : words) {
            // Convert to lowercase to avoid case mismatch (optional)
            word = word.toLowerCase();

            // If word already exists, increase count by 1, else start from 1
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Step 5: Display word frequency
        System.out.println("Word Frequency in paragraph:");
        for (String key : wordCount.keySet()) {
            System.out.println(key + " → " + wordCount.get(key));
        }
    }
}
