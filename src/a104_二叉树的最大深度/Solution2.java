package a104_二叉树的最大深度;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS层次遍历思想迭代实现二叉树最大深度
 * 时间复杂度O(n)
 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 *
 * @param root 根节点
 * @return 最大深度
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //BFS的层次遍历思想，记录二叉树的层数，
        //遍历完，层数即为最大深度
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }
}
// 3ms
