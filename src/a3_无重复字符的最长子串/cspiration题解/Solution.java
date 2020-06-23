package a3_无重复字符的最长子串.cspiration题解;

import java.util.HashMap;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-04-06 18:47
 **/
public class Solution {

    /**

     a b c a b c b b
     j = 3

     time : O(n)
     time : O(n)

     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j , map.get(s.charAt(i) + 1));
            }
        }

        return 0;
    }

}
