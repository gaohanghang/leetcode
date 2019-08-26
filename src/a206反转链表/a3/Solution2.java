package a206反转链表.a3;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-25 09:42
 **/
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
