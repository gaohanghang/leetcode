package a3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/31 13:57
 */
public class MySolution {
    public static void main(String[] args) {
        String str = "abcabcbb";
        lengthOfLongestSubstring2(str);
    }

    //
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j +1);
        }
        return res;
    }

    // 使用HashSet
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
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
