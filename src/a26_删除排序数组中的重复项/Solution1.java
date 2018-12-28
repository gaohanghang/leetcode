package a26_删除排序数组中的重复项;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/28 11:23
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int j = 0; // 慢指针
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) nums[++j] = nums[i];
        }
        return ++j;
    }
}
