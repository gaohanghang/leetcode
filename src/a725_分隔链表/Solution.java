package a725_分隔链表;

import java.util.Arrays;

/**
 * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表两次，得到链表的长度和分隔链表。
 * 空间复杂度：O(1)。只使用了常量的额外空间，注意返回值不计入空间复杂度。
 *
 * @author Gao Hanghang
 **/
class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10, null))))))))));
        ListNode[] listNodes = new Solution().splitListToParts(head, 3);
        /*
            输出结果：
            [ ListNode{val=1, next=ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=null}}}},
             ListNode{val=5, next=ListNode{val=6, next=ListNode{val=7, next=null}}},
             ListNode{val=8, next=ListNode{val=9, next=ListNode{val=10, next=null}}}
             ]
         */
        System.out.println(Arrays.toString(listNodes));
    }

    /**
     * 分割链表
     * <p>
     * 例子1：
     * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
     * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
     * <p>
     * 例子2：
     * 输入：head = [1,2,3], k = 5
     * 输出：[[1],[2],[3],[],[]]
     *
     * @param head 链表引用
     * @param k    分割数量
     * @return 链表数组
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 先经过一轮遍历，统计出链表的长度n
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            // 后移
            temp = temp.next;
        }

        // 整数商，例子：10 / 3 = 3
        int quotient = n / k;
        // 余数，例子：10 % 3 = 1
        int remainder = n % k;

        // 分割后的链表数组
        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            // 将 curr 作为当前部分的头结点
            parts[i] = curr;
            // 计算当前部分的长度 partSize；
            int partSize = quotient + (i < remainder ? 1 : 0);
            // 将 curr 向后移动 partSize 步，则 curr 为当前部分的尾结点
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }

            // 当 curr 到达当前部分的尾结点时，需要拆分 curr 和后面一个结点之间的连接关系，在拆分之前需要存储 curr 的后一个结点 next；
            ListNode next = curr.next;
            // 令 curr 的 next 指针指向 null，完成 curr 和 next 的拆分
            curr.next = null;
            // 将 next 赋值给 curr
            curr = next;
        }
        // 返回分割后的链表数组
        return parts;
    }

}

