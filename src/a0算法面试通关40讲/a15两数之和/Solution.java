package a0算法面试通关40讲.a15两数之和;

/**
 * @Description: 穷举法
 * @author: Gao Hang Hang
 * @date 2019/02/25 19:57
 */
public class Solution {
    int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
