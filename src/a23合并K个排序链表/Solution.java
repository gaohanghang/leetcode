package a23合并K个排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution {
    /**
     *
     * time : O(nlogk)
     * space : O(n)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 定义小根堆
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail  = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}
