package a133_克隆图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/clone-graph/solution/dfs-he-bfs-by-powcai/
 * @Description BFS(广度遍历)
 * @Author Gao Hang Hang
 * @Date 2019-08-18 19:08
 **/
public class Solution2 {

    /*
     map 存储原节点和复制节点的关系
     queue 存储节点
     */
    public Node cloneGraph(Node node) {
        // 如果node节点本身为null，直接返回null。
        if (node == null) return null;
        // 定义HashMap用于查找复制的node
        Map<Node, Node> lookup = new HashMap<>();
        // 复制的node
        Node clone = new Node(node.val, new ArrayList<>());
        // 存储原节点和克隆节点的映射关系
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                // map里面有从map里取出, 没有就put到map中去
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    // node存入queue
                    queue.offer(n);
                }
                // 给tmp的neighbors添加克隆节点
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        // 返回克隆节点
        return clone;
    }
}
