package a876_链表的中间结点;

/**
 * 方法一：输出到数组
 * 思路和算法
 * 按书顺序将每个结点放入数组A中。然后中间结点就是A[A.length/second],因为我们可以通过索引检索每个结点。
 *
 * 复杂度分析：
 *  - 时间复制度：O(N)，其中 N 是给定列表中的结点数目。
 *  - 空间复杂度：O(N)，A 用去的空间。
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/19 19:26
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
}
