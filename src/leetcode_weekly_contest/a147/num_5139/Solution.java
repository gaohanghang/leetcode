package leetcode_weekly_contest.a147.num_5139;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-07-28 12:48
 **/
public class Solution {

    public int tribonacci(int n) {
        int[] res = new int[n+5];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i-1] + res[i-2] + res[i-3];
        }
        return res[n];
    }

    public static void main(String[] args) {
        int tribonacci = new Solution().tribonacci(0);
        System.out.println(tribonacci);
    }
}
