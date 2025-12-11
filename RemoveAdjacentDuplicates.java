package java_assessment_day2;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String input = "abbaca";
        String result = removeDuplicates(input);
        System.out.println("After removing adjacent duplicates: " + result);
    }

    static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int lastIndex = sb.length() - 1;

            // If current char is same as last one, remove it
            if (sb.length() > 0 && sb.charAt(lastIndex) == c) {
                sb.deleteCharAt(lastIndex);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
