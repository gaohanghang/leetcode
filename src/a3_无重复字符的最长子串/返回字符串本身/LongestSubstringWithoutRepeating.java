package a3_无重复字符的最长子串.返回字符串本身;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-09-10 17:07
 **/
public class LongestSubstringWithoutRepeating {

    public static String LongestSubstringWithoutRepeating(String s) {
        // 用于记录字符的最新出现位置
        Map<Character, Integer> map = new HashMap();
        int maxLength = 0;  // 记录最长的子串长度
        int maxStart = 0;   // 记录最长子串的起始位置

        // 遍历字符串
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果当前字符已经存在于map中并且索引大于等于窗口的左边界
            if (map.containsKey(c)) {
                // 将窗口的左边界移动到重复字符之后的位置
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }

            // 更新字符的最新位置
            map.put(c, i);

            // 更新最长子串的长度和起始位置
            if (i - j + 1 > maxLength) {
                maxLength = i - j + 1;
                maxStart = j;
            }
        }

        // 返回最长无重复字符的子串
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String longestSubstring = LongestSubstringWithoutRepeating(s);
        System.out.println("最长无重复字符的子串是: " + longestSubstring);
    }

}
