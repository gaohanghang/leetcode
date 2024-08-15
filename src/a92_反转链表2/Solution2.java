package a92_反转链表2;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-08-15 17:25
 **/
public class Solution2 {
    // 1,   2,   3,   4,  5
    // pre cur next
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0; i< right - left; i++){
            next = cur.next;

            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}
