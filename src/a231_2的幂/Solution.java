package a231_2的幂;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @create: 2019/04/29 12:52
 */
public class Solution {
    // 只有一个1
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }

    // 8&(-8)->00001000 & 11111000 得 00001000
    public boolean isPowerOfTwo2(int n) {
        return n>0 && (n & (n-1)) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        return n>0 && (n & -n) == n;
    }
}
