package a160_相交链表;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/28 09:37
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        // 边界检查
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different len, then we will stop the loop after second iteration
        // 如果a＆b有不同的len，那么我们将在第二次迭代后停止循环
        while (a != b) {
            // for the end of first iteration, we just reset the pointer to the head of another linkedlist
            // 对于第一次迭代的结束，我们只是将指针重置为另一个链表的头部
            a = a == null ? headA : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
