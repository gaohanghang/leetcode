package a3_无重复字符的最长子串;

import java.nio.channels.Pipe;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 滑动窗口
 * @author: Gao Hang Hang
 * @date 2018/12/30 21:22
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongesSubstring2(s);
        System.out.println(i);
    }

    public static int lengthOfLongesSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j)
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongesSubstring2(String s) {
        int n = s.length(), ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
