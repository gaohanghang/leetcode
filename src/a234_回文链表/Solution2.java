package a234_回文链表;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/05 20:34
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode cur = head, fast = head, next = cur.next, left = null;
        while (fast.next != null && fast.next.next != null) {
            // 快指针先走2步
            fast = fast.next.next;
            // 进行反转

        }

        return false;
    }
}
