package a14_最长公共前缀;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-09-09 16:35
 **/
public class Solution2 {
    public String longestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
