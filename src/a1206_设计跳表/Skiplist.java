package a1206_设计跳表;

import java.util.Arrays;

/**
 * 跳表
 *
 * 时间复杂度：O(logn)
 * 空间复杂度：O(n)
 */
class Skiplist {

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();

        skiplist.add(4);
        skiplist.add(3);
        skiplist.add(2);
        skiplist.add(2);
        // false
        System.out.println(skiplist.search(0));
        skiplist.add(1);
        // true
        System.out.println(skiplist.search(1));
        // false，0 不在跳表中
        System.out.println(skiplist.erase(0));
        // true
        System.out.println(skiplist.erase(1));
        // false，1 已被擦除
        System.out.println(skiplist.search(1));

        System.out.println(skiplist);
    }

    /**
     * 最大层数
     */
    private static final int DEFAULT_MAX_LEVEL = 32;

    /**
     * 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过 maxLevel，层数的起始号为1
     */
    private static final double DEFAULT_P_FACTOR = 0.25;

    // 头节点
    Node head = new Node(null, DEFAULT_MAX_LEVEL);

    // 表示当前nodes的实际层数，它从1开始
    int currentLevel = 1;

    /**
     * 定义节点类
     */
    static class Node {
        // 节点值
        Integer value;
        // 节点在不同层的下一个节点
        Node[] next;

        // 用size表示当前节点在跳表中索引几层
        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + Arrays.toString(next) +
                    '}';
        }
    }

    public Skiplist() {
    }

    /**
     * 返回target是否存在于跳表中
     *
     * @param target 查询的值
     * @return boolean
     */
    public boolean search(int target) {
        Node searchNode = head;

        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, target);
            // 若找到符合条件的节点,即该节点的值与target相等,则返回true
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        // 若在最后一层也未找到符合条件的节点，则返回false
        return false;
    }

    /**
     * 插入一个元素到跳表
     *
     * @param num 插入元素
     */
    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        // 计算出当前 num 索引的实际层数，从该层开始添加索引
        for (int i = currentLevel - 1; i >= 0; i--) {
            // 找到本层最近离 num 最近的list
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > currentLevel) { //如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }

    }

    /**
     * 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
     *
     * @param num 要删除的值
     * @return boolean
     */
    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            // 若该节点为目标节点，则将其与当前层链表断开
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                // 找到该层中该节点
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }

    /**
     * 找到level层 value 刚好不小于 node 的节点
     *
     * @param node 从哪个节点开始找
     * @param levelIndex 所在层
     * @param value 查找节点值
     * @return Node
     */
    private Node findClosest(Node node, int levelIndex, int value) {
        while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }

    /**
     * 随机一个层数
     */
    private static int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }

    @Override
    public String toString() {
        return "Skiplist{" +
                "head=" + head +
                ", currentLevel=" + currentLevel +
                '}';
    }

}
