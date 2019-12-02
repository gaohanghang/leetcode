package a0算法面试题.面试题.无序数组的中位数;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description https://blog.51cto.com/14385862/2406489
 * @Author Gao Hang Hang
 * @Date 2019-12-01 20:30
 **/
public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{7,9,4,5};
        double median = median(array);
        System.out.println(median);
    }

    public static double median(int[] nums) {
        int heapSize = nums.length / 2 + 1;
        // 默认最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(nums[i]);
        }

        for (int i = heapSize; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.add(nums[i]);
            }
        }

        // 偶数个
        if (nums.length % 2 == 1) {
            return (double) heap.peek();
        } else { // 奇数个
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }

}
