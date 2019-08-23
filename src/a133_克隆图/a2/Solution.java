package a133_克隆图.a2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-18 21:07
 **/
public class Solution {

    // 定义一个辅助hash表，用于存储原节点和拷贝节点的映射关系
    private Map<Node, Node> lookup = new HashMap<>();

    public Node cloneGraph(Node node) {
        // 如果node节点本身为null，直接返回null。
        if (node == null) return null;
        // 如果相邻节点存在于Hash表中，把相应的相邻节点取出，作为当前节点的相邻节点
        if (lookup.containsKey(node)) return lookup.get(node);
        // 克隆节点
        Node clone = new Node(node.val, new ArrayList<>());
        // 原结点和映射关系存储到hash表
        lookup.put(node, clone);
        // 处理相邻节点，dfs(n,lookup)进行深度优先处理，克隆后的Node加到neighbors
        for (Node n : node.neighbors) clone.neighbors.add(cloneGraph(n));
        // 最后返回拷贝节点
        return clone;
    }
}
