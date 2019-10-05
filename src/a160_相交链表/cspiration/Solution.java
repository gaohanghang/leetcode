package a160_相交链表.cspiration;


/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-25 12:55
 **/
public class Solution {
    /**


     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
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
        return null;
    }

    public int len(ListNode head) {
        int len = 0;
        while(head != null) {
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
