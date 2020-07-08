//package a160_相交链表;
//
//import a160_相交链表.cspiration.ListNode;
//
///**
// * @Description: The catch here is that just calculate the difference in length of two linked list and then move the higher length list head to the calculated difference.
// * @author: Gao Hang Hang
// * @date 2019/03/01 13:17
// */
//public class Solution2 {
//    /**
//     * For example, the following two linked lists:
//     A:          a1 → a2
//     ↘
//     c1 → c2 → c3
//     ↗
//     B:     b1 → b2 → b3
//     begin to intersect at node c1.
//     time : O(n);
//     space : O(1);
//     * @param headA
//     * @param headB
//     * @return
//     */
//    public a160_相交链表.cspiration.ListNode getIntersectionNode(a160_相交链表.cspiration.ListNode headA, a160_相交链表.cspiration.ListNode headB) {
//        if (headA == null || headB == null) return null;
//
//        /* 获取链表长度 */
//        int lenA = len(headA);
//        int lenB = len(headB);
//
//        /* 将较长链表的指针向前移动 */
//        if (lenA > lenB) {
//            while (lenA != lenB) {
//                headA = headA.next;
//                lenA--;
//            }
//        } else {
//            while (lenA != lenB) {
//                headB = headB.next;
//                lenB--;
//            }
//        }
//
//        /* 同时移动两个元素，直到遇到相同元素 */
//        while (headA != headB) {
//            headA = headA.next;
//            headB = headB.next;
//        }
//        return headA;
//    }
//
//    public int len(ListNode head) {
//        int len = 1;
//        while (head != null) {
//            head = head.next;
//            len++;
//        }
//        return len;
//    }
//}
