package a25_K个一组翻转链表;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-25 01:50
 **/
public class Solution {

    /*
        给定这个链表：1->2->3->4->5

        当 k = 2 时，应当返回: 2->1->4->3->5

        当 k = 3 时，应当返回: 3->2->1->4->5

        1->2->3->4->5
        count = 0 cur = 1;
        count = 2 cur = 3;
            3->4->5
            count = 2 cur = 5
                5->null

       时间复杂度: O(n)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判断边界条件
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        // 如果 cur 不为空且 count 不等与 k继续循环
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            // 递归
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next; // 存储下一个节点
                head.next = cur; // 将当前节点的next域指向前一个节点
                cur = head; // cur 指针向后移动
                head = temp; // head 指针向后移动
            }
            head = cur;
        }
        // 5 -> null
        return head;
    }
}
