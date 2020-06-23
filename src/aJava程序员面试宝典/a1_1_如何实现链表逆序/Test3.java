package aJava程序员面试宝典.a1_1_如何实现链表逆序;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-06-02 02:24
 **/
public class Test3 {

    public static void ReversePrint(ListNode firstNode) {
        if (firstNode == null) {
            return;
        }
        ReversePrint(firstNode.next);
        System.out.print(firstNode.val + " ");
    }

    public static void main(String[] args) {
        // 链表头结点
        ListNode head = new ListNode();
        head.next = null;
        ListNode tmp = null;
        ListNode cur = head;
        // 构造单链表
        for (int i = 0; i < 8; i++) {
            // 填充数据
            tmp = new ListNode();
            tmp.val = i;
            tmp.next = null;
            // 当前结点 next 设置为 tmp
            cur.next = tmp;
            // tmp 赋值给 cur，相当于右移一位
            cur = tmp;
        }
        System.out.print("逆序前：");
        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

    }

}
