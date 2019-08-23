package a1_两数之和.a2019_8_15;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-15 20:16
 **/
public class Solution {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
