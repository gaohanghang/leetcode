package a1_两数之和;


/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/26 10:07
 */
public class Solution {

    // 方法一：暴力法 时间复杂度是o(n^second) 空间复杂度是o(1)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution"); // 例外异常
    }

}
