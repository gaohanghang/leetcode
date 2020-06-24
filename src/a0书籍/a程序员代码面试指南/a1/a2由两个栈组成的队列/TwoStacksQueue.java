package a0书籍.a程序员代码面试指南.a1.a2由两个栈组成的队列;

import java.util.Stack;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-06-24 09:45
 **/
public class TwoStacksQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    // push 栈向 pop 栈倒入数据
    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPop.pop());
            }
        }
    }

    public void add(int pushInt) {

    }

}
