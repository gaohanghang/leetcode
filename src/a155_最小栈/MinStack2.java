package a155_最小栈;

import java.util.Stack;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/13 12:39
 */
public class MinStack2 {
    Stack<Integer> stack, minStack = null;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            stack.pop();
            stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
