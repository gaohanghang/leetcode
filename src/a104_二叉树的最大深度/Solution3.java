package a104_二叉树的最大深度;


import java.util.Stack;
import java.util.TreeMap;

/**
 * DFS前序遍历思想迭代实现二叉树最大深度
 * 时间复杂度O(n)
 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 *
 * @param root 根节点
 * @return 最大深度
 */
public class Solution3 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        // DFS实现前序遍历，每个节点记录其所在深度
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // DFS过程不断比较更新最大深度
            int temp = value.pop();
            max = Math.max(temp, max);
            // 当前节点的子节点入栈，同时深度+1
            if (node.left != null) {
                stack.push(node.left);
                // 记录当前节点所在深度
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                // 记录当前节点所在深度
                value.push(temp + 1);
            }
        }
        return max;
    }

}
// 7ms
