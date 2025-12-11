// Implement a queue using two stacks.

package java_assessment_day2;

import java.util.Stack;

public class QueueUsingTwoStacks {

    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outputStack = new Stack<>();

    // Enqueue (add element to queue)
    public void enqueue(int value) {
        inputStack.push(value);
    }

    // Dequeue (remove front element from queue)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        // If output stack is empty, move all elements from input to output
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    // Peek (see front element without removing)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Demo main method
    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // 10

        System.out.println("Removed: " + queue.dequeue());    // 10
        System.out.println("Removed: " + queue.dequeue());    // 20

        queue.enqueue(40);
        System.out.println("Front element: " + queue.peek()); // 30
        System.out.println("Removed: " + queue.dequeue());    // 30
        System.out.println("Removed: " + queue.dequeue());    // 40

        System.out.println("Queue empty? " + queue.isEmpty()); // true
    }
}
