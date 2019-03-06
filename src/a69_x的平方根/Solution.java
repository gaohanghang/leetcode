package a69_x的平方根;

/**
 * @Description: 二分查找的方法
 * @author: Gao Hang Hang
 * @date 2019/03/04 20:00
 */
public class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        // 46341*46341会溢出，平方根必然在1~46340之间
        if (x > 46340) high = 46340;

        int mid = (low + high) / 2;
        while (low <= high) {
            if (x >= mid*mid && x <= mid*(mid+1)) return mid;
            else if (mid*mid < x)
                low = mid + 1;
            else high = mid -1;
            mid = (low + high) / 2;
        }
        return mid;
    }
}
