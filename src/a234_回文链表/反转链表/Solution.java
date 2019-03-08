package a234_回文链表.反转链表;

/**
 * https://www.jianshu.com/p/bd6a64d36916
 * @Description: 1 2 3 4 null
 *               4 3 2 1 null
 * @author: Gao Hang Hang
 * @date 2019/03/08 12:35
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            next = head.next; // 2赋值给next
            head.next = pre; // 1.next设为null
            pre = head; // 将head赋值给pre，即pre指向节点1，将节点1设为"上一个节点"。
            head = head.next; // 将2设为头节点
        }
        return pre;
    }
}
