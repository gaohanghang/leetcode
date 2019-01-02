package a0算法面试题.八大排序算法.笔试题;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 21:31
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, -1, 3, 0};
        // int[] nums = {1};
        int[] sortedNums = sort(nums);
        System.out.println(Arrays.toString(sortedNums));
    }

    public static int[] sort(int[] nums) {
        for(int i=0,j=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }

    public static int[] sort2(int[] nums) {
        for (int i = 0,j=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }
}
