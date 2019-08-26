package a206反转链表.a3;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-25 09:39
 **/
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
