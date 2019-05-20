package a80_删除排序数组中的重复项2;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-05-17 22:25
 *
 * 1 1 2 2 3 3
 *         idx
 *      loc
 **/
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(new Solution().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i -2])
                nums[i++] = n;
        return i;
    }
}
