package a114_二叉树展开链表;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-08-29 18:50
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
