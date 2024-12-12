package a1_两数之和.a2024_12_12;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-12-12 17:11
 **/
public class Solution {

    // 方法一：暴力法 时间复杂度是o(n^second) 空间复杂度是o(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
