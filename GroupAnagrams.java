//Implement a program to group anagrams from a list of words.
package java_assessment_day2;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        // Step 1: Input list of words
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Step 2: Create HashMap for grouping
        HashMap<String, List<String>> map = new HashMap<>();

        // Step 3: Loop through each word
        for (String word : words) {
            // Convert word into char array, sort it, and convert back to string
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // If key not present, create new list
            map.putIfAbsent(sortedWord, new ArrayList<>());

            // Add word to its corresponding group
            map.get(sortedWord).add(word);
        }

        // Step 4: Print grouped anagrams
        System.out.println("Grouped Anagrams:");
        for (List<String> group : map.values()) {
            System.out.println(group);
        }
    }
}
