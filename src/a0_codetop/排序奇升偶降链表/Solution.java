package a0_codetop.排序奇升偶降链表;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description https://www.cnblogs.com/GarrettWale/p/15865371.html
 * @date 2024-08-22 16:14
 **/
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //int[] input = {1, 8, 3, 6, 5, 4, 7, 2};
        //int[] input = {1,3,2,2,3,1};
        int[] input = {1,2,2};
        ListNode dumyOri = new ListNode(-1);
        ListNode ori = dumyOri;
        for (int i = 0; i < input.length; i++) {
            ori.next = new ListNode(input[i]);
            ori = ori.next;
        }

        ListNode res = sortList(dumyOri.next);
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        // 首先拆分奇偶链表
        ListNode dumyOdd = new ListNode(-1);
        ListNode odd = dumyOdd;

        ListNode dumyEven = new ListNode(-1);
        ListNode even = dumyEven;

        ListNode cur = head;
        int index = 1;
        while(cur != null) {
            if((index & 1) == 1) {
                odd.next = cur;
                odd = odd.next;
                index++;
            } else {
                even.next = cur;
                even = even.next;
                index++;
            }
            cur = cur.next;
        }

        odd.next = null;// 将尾节点置为null
        even.next = null;// 将尾节点置为null

        even = reverseList(dumyEven.next);
        odd = dumyOdd.next;

        return mergeList(odd, even);
    }

    //     1  2  3
    //pre cur
    // 3 2 1
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
