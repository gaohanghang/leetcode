package a692_前k个高频单词.TOPK问题解决思路;

import java.util.PriorityQueue;

/**
 * 第k大元素
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek())
                minQueue.offer(num);
            if (minQueue.size() > k)
                minQueue.poll();
        }
        return minQueue.peek();
    }
}
