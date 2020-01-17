package a139_单词拆分;

import java.util.*;

/**
 * @Description 方法 1：暴力
 * @Author Gao Hang Hang
 * @Date 2020-01-17 12:26
 **/
public class Solution {
    /*
    最简单的实现方法是用递归和回溯。为了找到解，我们可以检查字典单词中每一个单词的可能前缀，
    如果在字典中出现过，那么去掉这个前缀后剩余部分回归调用。
    同时，如果某次函数调用中发现整个字符串都已经被拆分且在字典中出现过了，
    函数就返回 true 。

    复杂度分析

    时间复杂度：O(n^n) 。考虑最坏情况 s = aaaaaaa 。每一个前缀都在字典中，此时回溯树的复杂度会达到 n^n
    空间复杂度：O(n) 。回溯树的深度最深达到 n 。
    */

    public static void main(String[] args) {
        String s = "leetcode";
        String[] arr = {"leet", "code"};
        List<String> wordDict = Arrays.asList(arr);
        Solution solution = new Solution();
        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet<>(wordDict), 0);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start) {
        // 边界条件
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}
