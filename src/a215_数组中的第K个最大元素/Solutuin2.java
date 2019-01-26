package a215_数组中的第K个最大元素;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/26 16:41
 */
public class Solutuin2 {
    public static int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (Integer n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(a, 2);
        System.out.println(kthLargest);
    }
}
