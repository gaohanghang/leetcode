package a367_有效的完全平方数;

/**
 * @Description: 使用二分查找
 * @author: Gao Hang Hang
 * @date 2019/03/20 08:33
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // mid*mid == num 就是完全平方，但是mid*mid可能太大，因此采用除法
            if (mid == (num*1.0 / mid)) {
                return true;
            } else if (mid > (num*1.0)/mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        new Solution().isPerfectSquare(5);
    }
}
