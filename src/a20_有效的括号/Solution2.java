package a20_有效的括号;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/31 20:36
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    private HashMap<Character, Character> mapping;

    public Solution2() {
        mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mapping.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != mapping.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
