package a215_数组中的第K个最大元素.a2;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-11-21 20:39
 **/
public class Solution2 {

    int[] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    //public int partition(int left, int right, int pivot_index) {
    //    int pivot = this.nums[pivot_index];
    //    // 1. move pivot to end
    //    swap(pivot_index, right);
    //    int store_index = left;
    //
    //    // 2.
    //}

}
