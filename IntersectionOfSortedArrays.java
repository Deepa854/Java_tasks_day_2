package java_assessment_day2;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8};

        System.out.print("Intersection: ");
        findIntersection(arr1, arr2);
    }

    static void findIntersection(int[] arr1, int[] arr2) {
        int i = 0; // pointer for arr1
        int j = 0; // pointer for arr2

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " "); // common element
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++; // move in arr1
            } else {
                j++; // move in arr2
            }
        }
    }
}
