package a141_环形链表;


import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：哈希表
 *
 * 思路：
 * 我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法
 * 是使用哈希表。
 *
 * 算法
 *
 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点
 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形
 链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。

 复杂度分析

 时间复杂度：O(n)O(n)， 对于含有 nn 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1)O(1) 的时间。

 空间复杂度：O(n)O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 n 个元素。
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
