//Given an array, find two numbers with the smallest absolute difference.

package java_assessment_day2;

import java.util.Arrays;

public class SmallestDifferenceFinder {
    public static void main(String[] args) {

        int[] numbers = {4, 2, 1, 3, 8, 10};  // Example array

        // Step 1: Sort the array
        Arrays.sort(numbers);

        int minDiff = Integer.MAX_VALUE; // store smallest difference
        int num1 = 0, num2 = 0;          // store the pair

        // Step 2: Compare each adjacent pair
        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = numbers[i + 1] - numbers[i]; // difference between adjacent numbers

            // Step 3: If smaller difference found, update
            if (diff < minDiff) {
                minDiff = diff;
                num1 = numbers[i];
                num2 = numbers[i + 1];
            }
        }

        // Step 4: Display result
        System.out.println("Two numbers with smallest absolute difference: " + num1 + " and " + num2);
        System.out.println("Smallest difference: " + minDiff);
    }
}
