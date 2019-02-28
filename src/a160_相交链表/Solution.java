package a160_相交链表;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/28 09:37
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            // for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headA : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
