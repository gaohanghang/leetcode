package a237_删除链表中的节点;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/18 11:53
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
