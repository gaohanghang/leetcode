package a20_有效的括号.题解;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-06-25 21:51
 **/
public class Solution {

    // Hash table that takes care of the mappings. 负责映射的哈希表。
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    // 使用映射初始化h ash map。这简单地方式使代码更容易阅读。
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm. 初始化一个栈
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket. 如果当前字符是结束括号
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                // 获取栈的顶部元素。如果栈为空，请设置虚拟值“＃”
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                // 如果此括号的映射与栈的top元素不匹配，则返回false。
                if (topElement != this.mappings.get(c)) return false;
            } else {
                // If it was an opening bracket, push to the stack. 如果它是一个左括号，推到栈。
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        // 如果栈仍然包含元素，那么它是一个无效的表达式。
        return stack.isEmpty();
    }
}
