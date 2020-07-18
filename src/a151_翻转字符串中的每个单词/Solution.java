package a151_翻转字符串中的每个单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用语言特性
 *
 * 时间复杂度：O(N)，其中 N 为输入字符串的长度。
 * 空间复杂度：O(N)，用来存储字符串分割之后的结果。
 */
class Solution {

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割 split
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // reverse
        Collections.reverse(wordList);
        // join
        return String.join(" ", wordList);
    }

}
