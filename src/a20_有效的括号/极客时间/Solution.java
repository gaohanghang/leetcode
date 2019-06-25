package a20_有效的括号.极客时间;

/**
 * @Description 时间复杂度 n^2 / 2
 * @Author Gao Hang Hang
 * @Date 2019-06-25 21:17
 **/
public class Solution {
    public boolean isValid(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }

    public static void main(String[] args) {
        new Solution().isValid("{()}");
    }
}
