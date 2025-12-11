//Find the first non-repeating element in an array using HashMap.

package java_assessment_day2;

import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {

        int[] numbers = {4, 5, 1, 2, 1, 4, 2};

        // Step 1: Create HashMap to store frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 2: Count frequency of each element
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Find first element with frequency 1
        int firstNonRepeat = -1;  // default if not found
        for (int num : numbers) {
            if (freqMap.get(num) == 1) {
                firstNonRepeat = num;
                break;
            }
        }

        // Step 4: Print result
        if (firstNonRepeat != -1)
            System.out.println("First non-repeating element: " + firstNonRepeat);
        else
            System.out.println("No non-repeating element found.");
    }
}
