package a100_相同的树;

/**
 * 递归的思想，分情况讨论：若两个结点都为空，返回true;只有一个为空，返回false;
 * 接下来是递归部分：若两个结点的值相同，则判断它左右结点是否相同。
 * 这个时候用到了 二者都为空的情况，即 两个节点的元素相同，且结点的左右结点都为空，则表示这两个结点相同了。
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 15:24
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}
