package a160_相交链表;

/**
 * @Description: The catch here is that just calculate the difference in length of two linked list and then move the higher length list head to the calculated difference.
 * @author: Gao Hang Hang
 * @date 2019/03/01 13:17
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        int lengthA = 0;
        int lengthB = 0;

        while (A != null || B != null) {
            if (A!=null){
                lengthA++;
                A = A.next;
            }
            if (B != null) {
                lengthB++;
                B = B.next;
            }
        }

        // 长的链表先走长的部分
        int diff = 0;
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            while (diff!=0) {
                headA = headA.next;
                diff--;
            }
        } else {
            diff = lengthB - lengthA;
            while (diff != 0) {
                headB = headB.next;
                diff--;
            }
        }

        // 长度一样
        while (headA!=null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
