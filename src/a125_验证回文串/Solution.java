package a125_验证回文串;

/**
 * @Description: 使用StringBuilder解决
 * @author: Gao Hang Hang
 * @date 2019/03/20 19:12
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if ( s== null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c < '9') || (c >= 'a' && c <= 'z')) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
