package a394_字符串解码;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description https://www.youtube.com/watch?v=Qoz3ujccNQY
 * @Author Gao Hang Hang
 * @Date 2019-10-23 21:15
 **/
public class Solution {

    /*
        s = "3[a2[c]]"

        accaccacc
     */
    public String decodeString(String s) {
        // 存储重复的次数
        Deque<Integer> numStack = new ArrayDeque<>();
        // 存String
        Deque<String> strStack = new ArrayDeque<>();


        StringBuilder tail = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果是数字
            if (Character.isDigit(c)) {
                int num = c - '0';
                // 判断下一位是否也是数字
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                numStack.push(num);
            } else if (c == '['){
                // 遇到左括号，将tail变为字符串存到strStack
                strStack.push(tail.toString());
                // 清空 tail
                tail = new StringBuilder();
            } else if (c == ']') {
                // 弹出 strStack 赋值给 tmp       a
                StringBuilder tmp = new StringBuilder(strStack.pop());
                // 获取重复次数
                int repeatedTimes = numStack.pop();
                for (int j = 0; j < repeatedTimes; j++) {
                    tmp.append(tail);
                }
                tail = tmp;
            } else {
                tail.append(c);
            }
        }
        return tail.toString();
    }
}
