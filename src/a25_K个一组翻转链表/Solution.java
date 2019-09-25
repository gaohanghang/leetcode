//package a25_K个一组翻转链表;
//
///**
// * @Description
// * @Author Gao Hang Hang
// * @Date 2019-09-25 01:50
// **/
//public class Solution {
//
//    /*
//        给定这个链表：1->2->3->4->5
//
//        当 k = 2 时，应当返回: 2->1->4->3->5
//
//        当 k = 3 时，应当返回: 3->2->1->4->5
//
//        1->2->3->4->5
//        count = 0 cur = 1;
//        count = 2 cur = 3;
//            3->4->5
//            count = 2 cur = 5
//                5->null
//
//
//     */
//
//    public ListNode reverseKGroup(ListNode head, int k) {
//        // 判断边界条件
//        if (head == null || head.next == null) return head;
//        int count = 0;
//        ListNode cur = head;
//        // 如果 cur 不为空且 count 不等与 k继续循环
//        while (cur != null && count != k) {
//            cur = cur.next;
//            count++;
//        }
//        if (count == k) {
//            cur = reverseKGroup(cur, k);
//        }
//    }
//}
