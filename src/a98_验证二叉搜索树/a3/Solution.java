package a98_验证二叉搜索树.a3;

import java.util.Stack;

/**
 * @Description 方法3：中序遍历 时间复杂度：O(n)，空间复杂度：O(n)
 * @Author Gao Hang Hang
 * @Date 2020-08-06 13:28
 **/
public class Solution {

    public boolean isVaildBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer inorder = null;

        while (!stack.isEmpty() || root != null) {

            // 不断将 root 的左子节点加入，直到没有剩余的左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            /*
                将当前子树最左边的节点从 stack 中取出，
                比较节点的值是否大于 inorder，
                如果小于等于 inorder，则二叉搜索树不合理
             */
            root = stack.pop();
            if (inorder != null && root.val <= inorder){
                return false;
            }

            /*
                将 inorder 设为当前节点的值
                将 root 设为当前节点的右子节
                继续循环
             */
            inorder = root.val;
            root = root.right;
        }

        return true;
    }


}
