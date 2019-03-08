package a234_回文链表;

/**
 * @Description: 使用快慢指针找到中点， 翻转后半部分比较
 * @author: Gao Hang Hang
 * @date 2019/03/05 20:34
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse逆序后半部分
        slow = reverse(slow.next);

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    // 翻转链表
    private ListNode reverse(ListNode head) { // 4 3 2 1 null
        // 递归到最后一个节点，返回新的头节点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
