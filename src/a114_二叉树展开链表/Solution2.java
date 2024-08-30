package a114_二叉树展开链表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-08-30 19:11
 **/
public class Solution2 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        Deque<TreeNode> stack = new LinkedList();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for(int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }
}
