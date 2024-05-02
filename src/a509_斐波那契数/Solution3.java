package a509_斐波那契数;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description 自底向上进行迭代
 * @date 2024-05-02 14:52
 **/
public class Solution3 {
    public int fib (int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
}
