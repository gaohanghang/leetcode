package a70_爬楼梯;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/18 00:09
 */
class Solution {

    // 递归的做法
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    //
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
