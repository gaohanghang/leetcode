package a104_二叉树的最大深度.blog;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree（二叉树的最大深度）
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Solution {
    /**
     * 递归
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

    public int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        int start = 0;
        int end = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            start++;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                depth++;
            }
        }
        return depth;
    }
}
