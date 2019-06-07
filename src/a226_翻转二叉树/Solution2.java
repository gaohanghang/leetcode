package a226_翻转二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-06-02 22:22
 **/
public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // LinkedList实现了集合框架的Queue接口
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 加入元素
        while (!queue.isEmpty()) {
            // 获取并移出元素
            TreeNode current = queue.poll();

            //交换左右子树
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            //左子树不为空，将左子树入栈
            if (current.left != null) queue.add(current.left);
            //右子树不为空，将右子树入栈
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
