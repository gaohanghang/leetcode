package a83删除排序链表中的重复元素.a2;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-02-16 21:26
 **/
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // 指定 current 指针指向头部 head，current用来遍历，head用来最后返回
        ListNode current = head;
        // current 和 current.next 的存在为循环结束条件，当二者有一个不存在时说明链表没有去重复的必要了
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                // 如果current和current.next的值相同，我们将current指向current.next后面的元素
                current.next = current.next.next;
            } else { // 如果元素不相同，移动current指针
                // 指针向后移动一位
                current = current.next;
            }
        }
        return head;
    }

}
