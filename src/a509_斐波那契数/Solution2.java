package a509_斐波那契数;

/**
 * @Description 自底向上进行迭代
 * @Author Gao Hang Hang
 * @Date 2020-12-09 22:58
 **/
public class Solution2 {
    public int fib(int N) {
        if(N <= 1) {
            return N;
        }

        int first = 0;
        int second = 1;
        // 加 N -1 次
        for (int i = 0; i < N-1; i++) {
            int sum = first + second;
            // 将第二个数给first
            /*
                    0          1          1
             第一步 first    second     sum = first + second
             第二步      first = second
             第二步                     second = sum
             */
            first = second;
            second = sum;
        }
        return second;
    }
}
