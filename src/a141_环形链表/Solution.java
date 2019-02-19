package a141_环形链表;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/19 20:09
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
