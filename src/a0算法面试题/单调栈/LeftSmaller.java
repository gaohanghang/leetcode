package a0算法面试题.单调栈;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description 给定一个长为N的整数数列，输出每个数左边第一个比它小的数，如果不存在输出-1
 * @date 2024-09-14 17:52
 **/
public class LeftSmaller {

    public static int[] findLeftSmaller(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // 栈中的元素大于等于当前元素时，弹出栈顶
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            // 如果栈为空，表示左边没有比当前元素小的
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // 将当前元素加入栈中
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,7,9};
        int[] result = findLeftSmaller(nums);

        // 打印结果
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
