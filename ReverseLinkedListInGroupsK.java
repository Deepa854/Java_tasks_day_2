//Reverse a linked list in groups of k.

package java_assessment_day2;

public class ReverseLinkedListInGroupsK {

    // Simple Node class for singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // ----------- MAIN LOGIC: reverse in groups of k -----------
    public static Node reverseInGroups(Node head, int k) {
        if (head == null || k <= 1) {
            return head; // no change needed
        }

        Node dummy = new Node(0); // fake start node
        dummy.next = head;

        Node groupPrev = dummy; // node before current group

        while (true) {
            // find the k-th node from groupPrev
            Node kth = getKthNode(groupPrev, k);
            if (kth == null) { // less than k nodes left
                break;
            }

            Node groupNext = kth.next; // first node after the group

            // reverse the group
            Node prev = groupNext;
            Node curr = groupPrev.next;

            while (curr != groupNext) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // connect previous part with reversed group
            Node temp = groupPrev.next; // this becomes end of group after reverse
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    // helper: move k steps from node, return that node (or null if not enough nodes)
    private static Node getKthNode(Node start, int k) {
        Node curr = start;
        for (int i = 0; i < k; i++) {
            if (curr.next == null) {
                return null;
            }
            curr = curr.next;
        }
        return curr;
    }

    // ----------- UTILITY METHODS FOR TESTING -----------
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

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // ----------- MAIN METHOD (example) -----------
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        Node head = buildList(values);

        System.out.println("Original list:");
        printList(head);

        head = reverseInGroups(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        printList(head);
    }
}
