package a108_将有效数组转换为二叉搜索树;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] nums, int low, int high) {
        // Done，边界条件
        if (low > high) {
            return null;
        }
        // 取中间值作为根节点
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // 使用递归方法构建左右子树
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
