package a367_有效的完全平方数;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/20 08:33
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1; // [1 ... i-1] contains value^2 <= num
        int j = num; // [j+1 ... n] contains value^2 > num
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                i = mid + 1;
                // [1 ... mid] contains value^2 <= num
            } else {
                j = mid - 1;
                // [mid ... n] contains value^2 > num
            }
        }
        return false;
    }
}
