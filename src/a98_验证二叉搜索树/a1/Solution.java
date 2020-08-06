package a98_验证二叉搜索树.a1;

/**
 * @Description 方法1：递归 时间复杂度：O(n)，空间复杂度：O(n)
 * @Author Gao Hang Hang
 * @Date 2020-08-06 12:55
 **/
public class Solution {

    public boolean isVaildBST(TreeNode root) {
        return recurse(root, null, null);
    }

    // 递归
    public boolean recurse(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        // 节点不为空，判断节点上的值是否在上下界内
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        // 将当前节点的值替换为下界，继续检查右边的子节点
        if (!recurse(node.right, val, upper)) {
            return false;
        }
        // 将当前节点的值替换为上界，继续检查左边的子节点
        if (!recurse(node.left, lower, val)) {
            return false;
        }

        return true;
    }

}
