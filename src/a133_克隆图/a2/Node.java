package a133_克隆图.a2;

import java.util.List;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-18 21:05
 **/
public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
