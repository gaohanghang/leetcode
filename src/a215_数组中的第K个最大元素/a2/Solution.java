package a215_数组中的第K个最大元素.a2;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-11-21 20:01
 **/
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }

}
