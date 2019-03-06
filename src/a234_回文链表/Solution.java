package a234_回文链表;

import java.util.Stack;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/05 13:22
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stackNode = new Stack<>();
        ListNode cur = head, next = head;
        int len = 0;

        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int n = len / 2;
        int x = 1;
        while (next != null) {
            if (x > n) {
                stackNode.push(next);
            }

        }

        return false;
    }
}
