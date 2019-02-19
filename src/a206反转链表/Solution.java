package a206反转链表;

/**
 *
 * 迭代法
 * 1 → 2 → 3 → Ø
 * Ø ← 1 ← 2 ← 3
 *
 * 先说下思路：所谓的单链表反转，就是把每个节点的指针域由原来的指向下一个节点变为指向其前一个节点。
 * 但由于单链表没有指向前一个节点的指针域，因此我们需要增加一个指向前一个节点的指针prev，
 * 用于存储每一个节点的前一个节点。此外，还需要定义一个保存当前节点的指针cur，以及下一个节点的next。
 * 定义好这三个指针后，遍历单链表，将当前节点的指针域指向前一个节点，之后将定义三个指针往后移动，直至遍历到最后一个节点停止。
 *
 * 在遍历列表时，将当前节点的下一个指针更改为指向其上一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素prev。在更改引用之前，还需要另一个指针nextTemp来存储下一个节点。
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/05 13:22
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 前一个节点
        ListNode curr = head; // 当前节点
        while (curr != null) {
            ListNode nextTemp = curr.next; // 存储下一个节点
            curr.next = prev; // 将当前节点的next域指向前一个节点
            prev = curr;      // prev 指针向后移动
            curr = nextTemp;  // curr 指针向后移动
        }
        return prev;
    }
}
