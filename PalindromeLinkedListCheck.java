//Check if a linked list is palindrome (without extra space).

package java_assessment_day2;

public class PalindromeLinkedListCheck {

    // Simple singly linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // -------- MAIN LOGIC: check palindrome without extra space --------
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // 0 or 1 node is always palindrome
        }

        Node slow = head;
        Node fast = head;
        Node prevSlow = null;

        // find middle using slow and fast pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        Node secondHalfStart;
        Node middleNode = null;

        // if fast is not null -> odd length, slow is at middle
        if (fast != null) {
            middleNode = slow;       // store middle node
            secondHalfStart = slow.next; // second half starts after middle
        } else {
            // even length, slow already at start of second half
            secondHalfStart = slow;
        }

        // break first half and second half
        prevSlow.next = null;

        // reverse second half
        Node secondHalfReversed = reverseList(secondHalfStart);

        // compare first half and reversed second half
        boolean result = compareLists(head, secondHalfReversed);

        // (Optional) restore original list by reversing back
        Node secondHalfOriginal = reverseList(secondHalfReversed);
        if (middleNode != null) {
            prevSlow.next = middleNode;
            middleNode.next = secondHalfOriginal;
        } else {
            prevSlow.next = secondHalfOriginal;
        }

        return result;
    }

    // reverse linked list (standard)
    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // compare two lists node by node
    private static boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true; // both must finish at same time for palindrome
    }

    // -------- helper to build list from array --------
    private static Node buildList(int[] values) {
        if (values.length == 0) return null;
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
        }
        return head;
    }

    // -------- helper to print list --------
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // -------- demo main --------
    public static void main(String[] args) {
        int[] values1 = {1, 2, 3, 2, 1};
        int[] values2 = {1, 2, 2, 1};
        int[] values3 = {1, 2, 3};

        Node head1 = buildList(values1);
        Node head2 = buildList(values2);
        Node head3 = buildList(values3);

        printList(head1);
        System.out.println("Is palindrome? " + isPalindrome(head1));

        printList(head2);
        System.out.println("Is palindrome? " + isPalindrome(head2));

        printList(head3);
        System.out.println("Is palindrome? " + isPalindrome(head3));
    }
}
