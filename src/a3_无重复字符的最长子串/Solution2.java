package a3_无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/30 21:13
 */
public class Solution2 {

    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) ans = Math.max(ans, j -i);
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
