package a148_排序链表;


/**
 * 参考：Sort List——经典（链表中的归并排序）
 * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
 * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
 * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
 * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
 * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
 * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
 * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
 * 主要考察3个知识点
 * 知识点1：归并排序的整体思想
 * 知识点2：找到一个链表的中间节点的方法
 * 知识点3：合并两个已排好序的链表为一个新的有序链表
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/26 22:26
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        /**
         * 归并排序稳定O(NlogN), 但是容易出错，需要注意细节
         */
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        // 用快慢指针找出中间节点并断开，对断开后的两个链表分别排序后再合并
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, mid = head;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;

        // head为左半部头节点，slow为右半部头结点
        ListNode lhead = sort(head);
        ListNode rhead = sort(slow);
        return merge(lhead, rhead);
    }

    private ListNode merge(ListNode lhead, ListNode rhead) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (lhead != null && rhead != null) {
            if (lhead.val < rhead.val) {
                cur.next = lhead;
                lhead = lhead.next;
            } else {
                cur.next = rhead;
                rhead = rhead.next;
            }
            cur = cur.next;
        }
        if (lhead != null) {
            cur.next = lhead;
        }
        if (rhead != null) {
            cur.next = rhead;
        }
        return head.next;
    }
}
