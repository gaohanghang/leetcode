package a82_删除排序链表中的重复元素2;

import java.util.List;

/**
 * @Description https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
 * @Author Gao Hang Hang
 * @Date 2020-02-16 22:44
 **/
//public class Solution {
//
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode FakeHead = new ListNode(0);
//        FakeHead.next = head;
//        ListNode pre = FakeHead;
//        ListNode cur = head;
//        while (cur != null) {
//            while (cur.next != null && cur.next.val) {
//                cur = cur.next;
//            }
//            if (pre.next == cur) {
//                pre = pre.next;
//            } else {
//                pre.next = cur.next;
//            }
//            // 指针向后移动一位
//            cur = cur.next;
//        }
//        return FakeHead.next;
//    }
//
//}
