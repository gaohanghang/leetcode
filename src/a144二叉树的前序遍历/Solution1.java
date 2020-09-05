package a144二叉树的前序遍历;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 递归
 * @Author Gao Hang Hang
 * @Date 2020-09-05 17:41
 **/
public class Solution1 {

    // 定义返回结果
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // 边界条件
        if (root == null) {
            return res;
        }

        // 添加根节点的值
        res.add(root.val);
        // 递归左孩子
        preorderTraversal(root.left);
        // 递归右孩子
        preorderTraversal(root.right);

        // 返回结果
        return res;
    }

}
