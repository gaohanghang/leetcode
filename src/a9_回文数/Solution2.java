package a9_回文数;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/28 19:12
 */
public class Solution2 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }

    // 判断是否是回文数
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reverse = new StringBuffer(s).reverse().toString();
        return s.equals(reverse);
    }


}
