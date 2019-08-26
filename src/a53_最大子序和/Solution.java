package a53_最大子序和;

/**
 * @Description: 动态规划解法
 * @author: Gao Hang Hang
 * @date 2019/01/11 21:24
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0]; // 最优解
        int dp  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}
