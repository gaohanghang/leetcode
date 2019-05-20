package a26_删除排序数组中的重复项.b站解法;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-05-17 19:05

 case : [1,1,2,2,3,4,5,6]
         1,2,3,4,5,6
           c
             i
 result : [1,2,3,4,5,6]

 time : O(n);
 space : O(1);
 **/
public class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
