package a0算法面试题.CS算法面试试听_算法基础知识;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/17 23:28
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(fibonacici(6));
    }

    public static int fibonacici(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacici(n - 1) + fibonacici(n - 2);
        }
    }

}
