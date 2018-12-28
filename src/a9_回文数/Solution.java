package a9_回文数;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/28 19:29
 */
public class Solution {
    public static void main(String[] args) {
        boolean b = IsPalindrome(12321);
        System.out.println(b);
    }



    // 12321
    public static boolean IsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0                                                                                                                                                                                 && x != 0)) return false;
        int palind = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 +  x % 10;
            x /= 10;
        }
        return palind == rev;
    }
}
