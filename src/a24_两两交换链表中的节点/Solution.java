package a24_两两交换链表中的节点;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-07-01 21:37
 *
 *
 https://www.youtube.com/watch?v=377ZjTI2NoM

 l1 -> 1 -> 2 -> 3 -> 4
     l2

 2 -> 1 -> 3 -> 4
      l1   l2
 **/
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
