//Given a string, check if it is rotation of another string (e.g., "ABCD" & "CDAB").

package java_assessment_day2;

public class CheckStringRotation {
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";

        // Check rotation
        if (isRotation(str1, str2)) {
            System.out.println(str2 + " is a rotation of " + str1);
        } else {
            System.out.println(str2 + " is NOT a rotation of " + str1);
        }
    }

    // Method to check if str2 is rotation of str1
    static boolean isRotation(String str1, String str2) {
        // If lengths are not same, cannot be rotation
        if (str1.length() != str2.length()) return false;

        // Combine str1 with itself and check if str2 exists inside
        String combined = str1 + str1;
        return combined.contains(str2);
    }
}
