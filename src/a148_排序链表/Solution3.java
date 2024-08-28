package a148_排序链表;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-06-07 19:08
 **/
public class Solution3 {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * 3 -> 7 -> 5 -> 1
     *
     * 3 -> 7 5 -> 1   1 3 7  5
     * 3 7  5 1
     * 3 7  1 5
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        // 链表断开
        ListNode next = middle.next;
        middle.next = null;
        // 合并
        return merge(sortList(head), sortList(next));
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) cur.next = b;
        else cur.next = a;

        return dummy.next;
    }
}
