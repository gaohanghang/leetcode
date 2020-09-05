package a144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 迭代
 * @Author Gao Hang Hang
 * @Date 2020-09-05 17:43
 **/
public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // 定义辅助栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 定义返回结果
        List<Integer> res = new ArrayList<>();

        // 如果root为空，返回空的结果
        if (root==null) {
            return res;
        }

        // 将 root 添加到栈中
        stack.push(root);

        // 如果栈不为空就一直运行
        while (!stack.isEmpty()) {
            // 从栈中取出数据
            TreeNode curr = stack.poll();
            // 给返回结果中添加数据
            res.add(curr.val);
            // 如果右孩子不为空，就添加的栈中。右孩子先添加到栈中是因为栈是先进后出
            if (curr.right != null) {
                stack.push(curr.right);
            }
            // 如果左孩子不为空，就添加的栈中
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        // 返回结果
        return res;
    }

}
