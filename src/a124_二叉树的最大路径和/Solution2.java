package a124_二叉树的最大路径和;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-02 22:18
 **/
public class Solution2 {
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        // 节点左右子树的最大总和
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        // 检查是维护旧路径还是创建新路径。创建新路径的权值是：price_newpath = node.val + left_gain + right_gain，当新路径更好的时候更新 max_sum。
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        // 如果新路径更好就更新max_sum
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}
