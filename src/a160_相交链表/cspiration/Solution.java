package a160_相交链表.cspiration;


/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-25 12:55
 **/
public class Solution {

    /**
     * For example, the following two linked lists:
     A:          a1 → a2
     ↘
     c1 → c2 → c3
     ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.
     time : O(n);
     space : O(1);
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        /* 获取链表长度 */
        int lenA = len(headA);
        int lenB = len(headB);

        /* 将较长链表的指针向前移动 */
        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }

        /* 同时移动两个元素，直到遇到相同元素 */
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        int len = new Solution().len(listNode);
        System.out.println(len);
    }
}
