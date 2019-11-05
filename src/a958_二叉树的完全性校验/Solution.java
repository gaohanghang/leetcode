package a958_二叉树的完全性校验;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description https://www.youtube.com/watch?v=xxIpSooeZfQ
 * @Author Gao Hang Hang
 * @Date 2019-11-06 00:20
 **/
public class Solution {
    /*
    思路:
        bfs 广度优先
        left -> right 一旦 null，后面全 null
    时间复杂度：O(N)，因为遍历了二叉树
    空间复杂度：O(N)，使用Queue
     */
    public boolean isCompleteTree(TreeNode root) {
        // corner case
        if (root == null) return true;
        // 是否遇到过空节点，true：遇到过null，false：没遇到过null
        boolean end = false;
        Queue<TreeNode> q = new LinkedList<>();
        // offer 添加一个元素并返回true  如果队列已满，则返回false
        q.offer(root);
        while (!q.isEmpty()) {
            // left -> right
            TreeNode node = q.poll(); // poll 移除并返问队列头部的元素  如果队列为空，则返回null
            // null
            if (node == null) {
                end = true;
            } else { // not null
                if (end) return false;
                // 添加左节点
                q.offer(node.left);
                // 添加右节点
                q.offer(node.right);
            }
        }
        return true;
    }
}


