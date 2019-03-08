package a234_回文链表;

import java.util.Stack;

/**
 * @Description: 使用栈解决
 * @author: Gao Hang Hang
 * @date 2019/03/05 13:22
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stackNode = new Stack<>();
        ListNode cur = head;
        ListNode next = head;

        // 获取中点长度   3 4 5 9
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int n = len / 2;  // 2

        int x = 1;
        while (next != null) {
            if (x > n) {
                stackNode.push(next);
            }
            next = next.next;
            x++;
        }

        while (!stackNode.isEmpty()) {
            if (stackNode.pop().val != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }
}
