//Write a program to move all zeros to the end of an array without changingthe order of non-zero elements.


package java_assessment_day2;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};

        int index = 0;  // to track position for non-zero elements
        for (int num : numbers) {
            if (num != 0) {
                numbers[index++] = num; // move non-zero to front
            }
        }

        while (index < numbers.length) {
            numbers[index++] = 0; // fill remaining places with 0
        }

        // Display the updated array
        System.out.print("After moving zeros: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
