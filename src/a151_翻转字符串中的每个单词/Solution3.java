package a151_翻转字符串中的每个单词;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用双端队列/栈
 *
 *  时间复杂度：O(N)
 *  空间复杂度：O(N)
 *
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-18 17:59
 **/
public class Solution3 {

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;

        // 处理空格
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // remove tralling spaces
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        // push word by word in front of deque
        // 取出单词
        while (left <= right) {
            char c = s.charAt(left);

            if (word.length() != 0 && c == ' ') { // 遇到空格，说明碰到完整的单词
                d.offerFirst(word.toString());
                word.setLength(0); // 清空word
            } else if (c != ' ') { // 拼接单词
                word.append(c);
            }
            ++ left;
        }
        d.offerFirst(word.toString()); // 循环结束时，加入最后一个单词

        return String.join(" ", d); // 最后把单词拼接起来，并且用空格隔开
    }

}
