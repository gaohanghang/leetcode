package a0算法面试题.面试题;

import java.util.Stack;

/**
 * @Description 实现一个栈，要求pop push getMin的时间复杂度都是O(1)【图解流程】
 * https://blog.csdn.net/u010452388/article/details/81665826
 * @Author Gao Hang Hang
 * @Date 2019-10-04 03:34
 **/
public class GetMinStack {
    // 声明一个data栈
    private Stack<Integer> dataStack;
    // 声明一个min栈
    private Stack<Integer> minStack;

    // 构造函数
    public GetMinStack(Stack<Integer> dataStack, Stack<Integer> minStack) {
        this.dataStack = dataStack;
        this.minStack = minStack;
    }

    // 入栈
    public void push(int num) {
        //1.入栈有两种情况
        //1.1 栈为空，那么第一个数直接进data栈和min栈
        //1.2 栈不为空，data栈正常入，入min栈的时候，先与min栈的栈顶数据进行比较，小的数入min栈
        if (dataStack.isEmpty()) {//栈为空
            dataStack.push(num);
            minStack.push(num);
        } else {//栈不为空
            dataStack.push(num);
            if (num < minStack.peek()) {
                minStack.push(num);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }

    // 弹栈
    public Integer pop() {
        // 弹栈的时候，data栈和min栈一起弹出，如果栈为空，则先提醒用户
        if (dataStack.isEmpty()) {
            throw new IllegalArgumentException("栈已空");
        }
        minStack.pop();
        return dataStack.pop();
    }

    // 取最小值
    public Integer getMin() {
        // 直接获取最小栈的数据即可，如果栈为空，则先提醒用户
        if (dataStack.isEmpty()) {
            throw new IllegalArgumentException("栈已空");
        }
        return minStack.peek();
    }
}
