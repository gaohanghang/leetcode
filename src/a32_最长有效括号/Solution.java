package a32_最长有效括号;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int i = longestValidParentheses(")");
        System.out.println(i);
    }

	private static int longestValidParentheses(String s) {
		int maxans = 0;
        Stack<Integer> stack =  new Stack();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 左括号
                stack.push(i);
            } else { // 右括号
                stack.pop(); // 先弹出栈顶元素表示匹配了当前右括号
                if (stack.isEmpty()) { // 如果栈为空，说明当前的右括号为没有被匹配的左括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek()); // 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                }
            }
        }

        return maxans;
	}
}
