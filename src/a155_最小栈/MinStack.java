package a155_最小栈;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @Description: 双栈
 * @author: Gao Hang Hang
 * @date 2019/03/12 18:23
 */
public class MinStack {

    Stack<Integer> stack, minStack = null;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        // 栈顶元素与最小元素相等就都出栈
        if (stack.peek().equals(minStack.peek())) {
            stack.pop();
            minStack.pop();
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
