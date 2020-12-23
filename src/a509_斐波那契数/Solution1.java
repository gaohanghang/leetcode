package a509_斐波那契数;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-12-09 23:00
 **/
public class Solution1 {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }
}
