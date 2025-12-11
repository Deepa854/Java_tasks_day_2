package java_assessment_day2;

public class DetectCycleStartInLinkedList {

    // Simple singly linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // -------- MAIN LOGIC: find start of cycle (or null if no cycle) --------
    public static Node findCycleStart(Node head) {
        if (head == null || head.next == null) {
            return null; // no cycle possible
        }

        Node slow = head;
        Node fast = head;

        // 1) Detect if there is a cycle using slow & fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {         // meeting point → cycle exists
                break;
            }
        }

        // no cycle (fast reached end)
        if (fast == null || fast.next == null) {
            return null;
        }

        // 2) Find start of cycle:
        // move slow to head, keep fast at meeting point
        slow = head;
        while (slow != fast) {
            slow = slow.next;   // move both 1 step
            fast = fast.next;
        }

        // the node where they meet is the start of the cycle
        return slow;
    }

    // ---------- Helper: build a simple list ----------
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

    // ---------- Helper: create a cycle for testing ----------
    // pos = index (0-based) where tail should point ( -1 means no cycle )
    private static Node createCycle(Node head, int pos) {
        if (head == null || pos < 0) return head;

        Node tail = head;
        Node cycleNode = null;
        int index = 0;

        while (tail.next != null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }
        // last node
        if (index == pos) {
            cycleNode = tail;
        }

        // make cycle
        if (cycleNode != null) {
            tail.next = cycleNode;
        }
        return head;
    }

    // ---------- Demo main ----------
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        Node head = buildList(values);

        // create a cycle: tail points to node with value 3 (index 2)
        head = createCycle(head, 2);

        Node cycleStart = findCycleStart(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.data);
        } else {
            System.out.println("No cycle in the list.");
        }
    }
}
