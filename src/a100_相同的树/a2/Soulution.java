package a100_相同的树.a2;

/**
 * @Description 迭代法
 * @Author Gao Hang Hang
 * @Date 2019-05-15 07:58
 **/
public class Soulution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
}
