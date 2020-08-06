package a98_验证二叉搜索树.a2;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 方法2：迭代
 * @Author Gao Hang Hang
 * @Date 2020-08-06 13:16
 **/
public class Solution {

    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>();
    LinkedList<Integer> lowers = new LinkedList<>();

    /**
     * update 函数能够将当前节点和节点所对应的上下界存入对应的栈中
     *
     * @param root
     * @param lower
     * @param upper
     */
    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isVaildBST(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            // 每次从栈中取出一个节点
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) {
                continue;
            }
            val = root.val;

            // 比价过后继续把左子节点和右子节点加入栈
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            update(root.right, val, upper);
            update(root.left, lower, val);
        }

        return true;
    }

}
