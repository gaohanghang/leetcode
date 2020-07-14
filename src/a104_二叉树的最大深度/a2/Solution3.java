package a104_二叉树的最大深度.a2;

import org.graalvm.compiler.nodes.extended.ValueAnchorNode;

import java.util.Stack;

/**
 *  时间复杂度O(n)
 *  空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-15 00:14
 **/
public class Solution3 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int maxDepth = 0;
        // DFS实现前序遍历，每个节点记录器所在深度
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer temp = value.pop();

            maxDepth = Math.max(temp, maxDepth);

            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return maxDepth;
    }

}
// 7ms
