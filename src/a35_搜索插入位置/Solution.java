package a35_搜索插入位置;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 13:32
 */
public class Solution {
    public static void main(String[] args) {
        searchInsert2(new int[]{1,2,3,6,7}, 5);
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (i = 0; i < nums.length; i++)
            if (target <= nums[i]) break;
        return i;
    }

    // 12367 5
    public static int searchInsert2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }
        return low;
    }
}
