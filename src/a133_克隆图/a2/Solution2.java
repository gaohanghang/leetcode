package a133_克隆图.a2;

import com.sun.org.apache.bcel.internal.generic.NOP;

import java.util.*;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-18 22:59
 **/
public class Solution2 {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }
}
