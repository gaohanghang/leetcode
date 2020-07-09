package a104_二叉树的最大深度;


/**
 * @Description 测试
 * @Author Gao Hang Hang
 * @Date 2020-07-08 20:47
 **/
public class Test {

    public static void main(String[] args) {
        //Solution solution = new Solution();
        //Solution2 solution = new Solution2();
        Solution3 solution = new Solution3();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(root));
    }

}
