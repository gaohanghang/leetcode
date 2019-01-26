package a215_数组中的第K个最大元素;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 使用堆
 * @author: Gao Hang Hang
 * @date 2019/01/24 09:54
 */
public class Solution {
    /*
       Complexity Analysis
           Time complexity : O(Nlog(k)).
           pace complexity : O(k).
    */

    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first' 初始化第一个元素最小的堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 优先队列

        // keep k largest elements in the heap
        // 将第k大的元素保留在heap中
        for (Integer n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        System.out.println(new Solution().findKthLargest(a, 2));
    }
}
