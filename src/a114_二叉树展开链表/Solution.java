package a114_二叉树展开链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-08-29 18:46
 **/
public class Solution {
    public void flatten(TreeNode  root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
