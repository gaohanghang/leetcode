package a151_翻转字符串中的每个单词.a2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-19 17:14
 **/
public class Solution3 {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && c == ' ') { // 如果为空格
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
