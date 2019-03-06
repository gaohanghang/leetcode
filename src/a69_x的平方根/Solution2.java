package a69_x的平方根;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/05 13:00
 */
public class Solution2 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        double m = (double) x;
        double k = 1;
        while (Math.abs(k - m / k) >= 0.000001) {
            k = (k + m / k) / 2.0;
        }
        return (int)k;
    }
}
