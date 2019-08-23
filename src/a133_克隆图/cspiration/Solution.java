package a133_克隆图.cspiration;

import a133_克隆图.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-18 18:37
 **/
public class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node dup = new Node(node.val);

    }
}
