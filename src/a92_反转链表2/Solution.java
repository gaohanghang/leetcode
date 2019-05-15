package a92_反转链表2;

public class Solution {
    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

    // 递归和反转
    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Dont't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one ste forward until (n == 1)
        right = right.next;

        // Keep moving the right pointer one step forward until (n == 1)
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        //
    }

}
