package a206反转链表.second;

/*
方法一：迭代
在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节
点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。
不要忘记在最后返回新的头引用！
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // 存储下一个节点
            curr.next = prev; // next指针指向前一个元素
            prev = curr; // prev向前走
            curr = nextTemp; // curr向前走
        }
        return prev;
    }
}
/*
复杂度分析
- 时间复杂度：O(n)。假设 n 是列表的长度，时间复杂度是O(n)
- 空间复杂度：O(1)

空间复杂度O(1)意味着不能复制一个临时链表出来，必须在原链表上直接操作
 */