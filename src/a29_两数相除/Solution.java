package a29_两数相除;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @create: 2019/04/29 23:45
 */
public class Solution {

    /**
     * 1, + -
     * 2, 越界
     * 3, = 0 3/5
     * 4, 正常
     *


     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor || ldividend == 0) return 0;

        long lres = divide(ldividend, ldivisor);

        return 0;
    }

    private long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return 0;
    }
}
