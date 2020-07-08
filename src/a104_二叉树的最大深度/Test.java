package a104_二叉树的最大深度;


/**
 * @Description 测试
 * @Author Gao Hang Hang
 * @Date 2020-07-08 20:47
 **/
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.left.right = new TreeNode(0);
        System.out.println(solution.maxDepth(root));
    }

}
