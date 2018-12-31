package a3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 优化的滑动窗口
 * @author: Gao Hang Hang
 * @date 2018/12/30 21:56
 */
public class Solution4 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        lengthOfLongestSubstring2(str);
    }

    // 方法三：优化的滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        //
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    // Java（假设字符集为 ASCII 128）
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
