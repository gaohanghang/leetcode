package a206反转链表.second;

/*
方法二：递归

 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        // 如果链表为空或者链表中只有一个元素
        if (head == null || head.next == null) return head;
        // 先反转后面的链表，走到链表的末端结点
        ListNode p = reverseList(head.next);
        // 再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;
        return p;
    }
}
