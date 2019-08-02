package a24_两两交换链表中的节点.递归;


/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-07-01 23:07
 *
 * 1 2 3 4
 *   next
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
