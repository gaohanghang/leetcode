package a0书籍.a程序员代码面试指南.a1.a1设计一个有getMin功能的栈;

import java.util.Stack;

/**
 * 方案一和方案二其实都是用 stackMin 栈保存着 stackData 每一步的最小值。共同点是所有操作的时间复杂度都为O（1）、空间复杂度都为O（n）。
 * 区别是：方案一中stackMin压入时稍省空间，但是弹出操作稍费时间；方案二中stackMin压入时稍费空间，但是弹出操作稍省时间。
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-06-22 12:17
 **/
public class MyStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<Integer>();
        this.stackMin= new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getmin()){
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

}
