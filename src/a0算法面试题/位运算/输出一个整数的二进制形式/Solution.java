package a0算法面试题.位运算.输出一个整数的二进制形式;

import java.util.Scanner;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-09-19 19:06
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Integer number = Integer.valueOf(s[0]);
        print(number);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.println(((num & (1 << i)) == 0) ? "0" : "1");
        }
    }
}
