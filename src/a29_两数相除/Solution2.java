package a29_两数相除;

public class Solution2 {
    public int divide(int dividend, int divisor) {
        // Reduce the problem to positive long integer to make it easier.
        // Use long avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldividor = Math.abs((long) divisor);

        // Take care the edge cases. 注意边界条件
        if (ldividor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldividor)) return 0;

        long lans = ldivide(ldividend, ldividor);

        int ans;
        if (lans > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldividor) {
        // Recursion exit condition 递归退出条件
        if (ldividend < ldividor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        return 0;
    }
}
