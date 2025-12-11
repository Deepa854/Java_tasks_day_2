//Check if two strings are anagrams without sorting (HashMap only).

package java_assessment_day2;

import java.util.HashMap;

public class AnagramChecker {
    public static void main(String[] args) {

        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println("✅ The strings are anagrams.");
        } else {
            System.out.println("❌ The strings are NOT anagrams.");
        }
    }

    public static boolean areAnagrams(String s1, String s2) {

        // Step 1: If lengths differ, not anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Create HashMap for counting characters in s1
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Reduce count using s2 characters
        for (char ch : s2.toCharArray()) {
            if (!charCount.containsKey(ch)) {
                return false; // Character not found
            }
            charCount.put(ch, charCount.get(ch) - 1);

            // If count goes below 0 → not anagram
            if (charCount.get(ch) < 0) {
                return false;
            }
        }

        // Step 4: Check if all counts are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true; // All matched
    }
}
