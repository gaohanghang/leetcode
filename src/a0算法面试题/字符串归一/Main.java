package a0算法面试题.字符串归一;

import java.util.Scanner;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-03-17 02:11
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();

        //经验，一般是用hashmap来统计出现次数的，
        //但本题是对字符统计次数，可以专门用一个counts数组来统计次数
        int[] counts = new int[26];
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            int count = counts[i];
            if (count == 0) {
                continue;
            } else {
                System.out.print(c + "" + count);
            }
        }
    }

}
