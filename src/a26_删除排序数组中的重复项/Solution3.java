package a26_删除排序数组中的重复项;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2025-03-16 20:13
 **/
public class Solution3 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
