package com;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-12-06 17:27
 **/
public class Main {

    /**
     *
     * 0 1 2 3 5 8 13 ....
     * 第0项是0，第1项是第一个1。
     * 这个数列从第三项开始，每一项都等于前两项之和。
     * @param n
     * @return
     */

    // 递归写法
    public static int fib1(int n) {
        if(n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n-2);
    }

    public static int fib2(int n) {
        if(n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        // 加 n -1 次
        for (int i = 0; i < n-1; i++) {
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

    public static void main(String[] args) {
        //System.out.println(fib1(19));
        //System.out.println(fib2(19));

        TimeTool.check("fib1" , () -> {
            System.out.println(fib1(45));
        });

        TimeTool.check("fib12" , () -> {
            System.out.println(fib2(45));
        });
    }

}
