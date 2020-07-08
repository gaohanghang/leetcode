package a104_二叉树的最大深度;

/**
 * 递归实现二叉树最大深度
 * 时间复杂度O(n)
 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 *
 * @param root 根节点
 * @return 最大深度
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 递归退出条件，到叶子节点
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
// 0 ms
