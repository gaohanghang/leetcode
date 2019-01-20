package a0算法面试题.CS算法面试试听_算法基础知识.a3_7_二分查找;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/18 14:57
 */
public class Test {
    public static void main(String[] args) {

    }

    // 二分查找
    public int binarySearch (int[] nums, int low, int high, int target) {
        if (high <= low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if ( nums[mid] > target) {
            return binarySearch(nums, low, mid, target);
        } else if (nums[mid] < target){
            return binarySearch(nums, mid, high, target);
        } else {
            return mid;
        }
    }
}
