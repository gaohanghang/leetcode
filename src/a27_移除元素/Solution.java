package a27_移除元素;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/28 14:40
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2};
        removeElement(nums, 2);

        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
