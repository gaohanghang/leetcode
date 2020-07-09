# LeetCode 104 二叉树的深度



<a name="fr76z"></a>
## 题目

<br />输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。<br />
<br />例如：<br />
<br />给定二叉树 [3,9,20,null,null,15,7]，<br />

```sql
    3
   / \
  9  20
    /  \
   15   7
```

<br />返回它的最大深度 3 。<br />
<br />提示：<br />
<br />节点总数 <= 10000<br />注意：本题与主站 104 题相同：[https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)<br />
<br />来源：力扣（LeetCode）<br />链接：[https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof)<br />著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />

<a name="NRbM0"></a>
## 解法


<a name="iwEIG"></a>
### 1. 递归


```java
/**
 * 递归实现二叉树最大深度
 * 时间复杂度O(n)
 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 *
 * @param root 根节点
 * @return 最大深度
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 递归退出条件，到叶子节点
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
// 0 ms
```


<a name="lhLCX"></a>
### 2. 迭代


<a name="m81Yn"></a>
#### 2.1 BFS 广度优先


```java
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS层次遍历思想迭代实现二叉树最大深度
 * 时间复杂度O(n)
 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 *
 * @param root 根节点
 * @return 最大深度
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // BFS的层次遍历思想，记录二叉树的层数，
        // 遍历完，层数即为最大深度
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            // 每层size
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }
}
// 3ms
```


<a name="cDv3Y"></a>
#### 2.2 DFS前序遍历思想


```java
import java.util.Stack;
import java.util.TreeMap;

/**
 * DFS前序遍历思想迭代实现二叉树最大深度
 * 时间复杂度O(n)
 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
 *
 * @param root 根节点
 * @return 最大深度
 */
public class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int maxDepth = 0;
        // DFS实现前序遍历，每个节点记录其所在深度
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // DFS过程不断比较更新最大深度
            int temp = value.pop();
            maxDepth = Math.max(temp, maxDepth);
            // 当前节点的子节点入栈，同时深度+1
            if (node.left != null) {
                stack.push(node.left);
                // 记录当前节点所在深度
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                // 记录当前节点所在深度
                value.push(temp + 1);
            }
        }
        return maxDepth;
    }
}
// 7ms
```

<br />测试代码<br />

```sql
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
```

<br />TreeNode.java<br />
```sql
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
```


<a name="R1Wio"></a>
## 参考

<br />[https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/javashi-xian-san-chong-fang-fa-di-gui-shi-xian-die/](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/javashi-xian-san-chong-fang-fa-di-gui-shi-xian-die/)<br />
<br />[https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/34195/Two-Java-Iterative-solution-DFS-and-BFS](https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/34195/Two-Java-Iterative-solution-DFS-and-BFS)
