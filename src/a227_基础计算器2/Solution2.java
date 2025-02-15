package a227_基础计算器2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-09-22 17:26
 **/
public class Solution2 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

        }


        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
