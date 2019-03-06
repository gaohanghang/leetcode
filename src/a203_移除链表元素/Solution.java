package a203_移除链表元素;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/01 22:21
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 不要忘记对头结点的比较
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        header.next = head;

        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return header.next;
    }
}
