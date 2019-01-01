package a66_加一;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 15:40
 */
public class Solution {
    public static void main(String[] args) {

    }

    //[4,3,2,1]
    public int[] plusOne(int[] digits) {
        int carry = 1, sum = 0, n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] result = new int[n+1];
            result[0] = 1;
            digits = result;
        }
        return digits;
    }
}
