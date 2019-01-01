package a20_有效的括号;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/31 19:53
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValid("()[]{}");
    }

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mapping. This simply makes the code easier to read.
    public Solution() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}','{');
        mappings.put(']','[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
