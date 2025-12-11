package java_assessment_day2;

import java.util.HashMap;
import java.util.Map;

public class SecondMostFrequentChar {
    public static void main(String[] args) {
        String text = "successes";

        Character result = findSecondMostFrequentChar(text);

        if (result != null) {
            System.out.println("Second most frequent character: " + result);
        } else {
            System.out.println("No second most frequent character found.");
        }
    }

    static Character findSecondMostFrequentChar(String text) {
        if (text == null || text.isEmpty()) return null;

        // 1️⃣ Count frequency of each character using HashMap
        Map<Character, Integer> countMap = new HashMap<>();

        for (char ch : text.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // 2️⃣ Find most frequent and second most frequent
        char firstChar = 0, secondChar = 0;
        int firstMax = 0, secondMax = 0;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            if (freq > firstMax) {
                // shift current first to second
                secondMax = firstMax;
                secondChar = firstChar;

                firstMax = freq;
                firstChar = ch;
            } else if (freq > secondMax && freq < firstMax) {
                secondMax = freq;
                secondChar = ch;
            }
        }

        if (secondMax == 0) return null; // no second most frequent
        return secondChar;
    }
}
