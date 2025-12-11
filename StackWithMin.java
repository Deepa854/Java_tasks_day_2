//Implement a stack with getMin() in O(1) time.


package java_assessment_day2;

import java.util.Stack;

public class StackWithMin {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    // push element onto stack
    public void push(int value) {
        mainStack.push(value);
        // if minStack is empty or new value is smaller or equal, push to minStack
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    // pop element from stack
    public int pop() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int removed = mainStack.pop();
        // if removed element is current minimum, remove from minStack also
        if (removed == minStack.peek()) {
            minStack.pop();
        }
        return removed;
    }

    // see top element
    public int peek() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return mainStack.peek();
    }

    // get minimum element in O(1)
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

    // simple demo
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();

        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);

        System.out.println("Current min: " + stack.getMin()); // 1

        stack.pop(); // remove 1

        System.out.println("Top element: " + stack.peek());   // 8
        System.out.println("Current min: " + stack.getMin()); // 2
    }
}
