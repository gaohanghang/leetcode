package a133_克隆图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目: https://leetcode-cn.com/problems/clone-graph
 * 视频: https://leetcode-cn.com/problems/clone-graph/solution/dfs-he-bfs-by-powcai/
 * 视频: https://www.youtube.com/watch?v=MOCCC_B3kNg
 * @Description DFS(深度遍历)
 * @Author Gao Hang Hang
 * @Date 2019-08-18 10:51
 **/
public class Solution {

    /**

     1--2
     |
     |
     3--5

     1 : 2 3

     */

    // 定义一个辅助hash表，用于存储原节点和拷贝节点的映射关系
    private Map<Node, Node> lookup = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        // 如果node节点本身为null，直接返回null。
        if (node == null) return null;
        // 如果相邻节点存在于Hash表中，把相应的相邻节点取出，作为当前节点的相邻节点
        if (lookup.containsKey(node)) return lookup.get(node);
        // 复制的node
        Node clone = new Node(node.val, new ArrayList<>());
        // 原结点和映射关系存储到hash表
        lookup.put(node, clone);
        // 处理相邻节点，dfs(n,lookup)进行深度优先处理，克隆后的Node加到neighbors
        for (Node n : node.neighbors) clone.neighbors.add(dfs(n));
        // 最后返回拷贝节点
        return clone;
    }
}
