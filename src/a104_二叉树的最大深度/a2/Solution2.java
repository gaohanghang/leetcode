package a104_二叉树的最大深度.a2;


import java.util.LinkedList;
import java.util.TreeMap;

/**
 *  时间复杂度O(n)
 *  空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-15 00:07
 **/
public class Solution2 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
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
