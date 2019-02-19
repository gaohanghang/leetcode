package a206反转链表;

/**
 * 1 → 2 → 3 → 4 → Ø
 * Ø ← 1 ← 2 ← 3 ← 4
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/05 13:54
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // 边界条件，当前节点或指针域为null的话return
        // 将去掉head节点的部分反转
        ListNode p = reverseList(head.next);
        // 将head节点放到反转后的链表最后，head.next为headNode列表的最后一个节点
        head.next.next = head; // 4.next.next =  2 走两步，断开2和3的连接
        head.next = null;
        return p;
    }
}
