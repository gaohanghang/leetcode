package a26_删除排序数组中的重复项;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/28 13:37
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}
