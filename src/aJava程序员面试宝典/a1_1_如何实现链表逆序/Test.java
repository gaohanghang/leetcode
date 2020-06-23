package aJava程序员面试宝典.a1_1_如何实现链表逆序;

import java.util.List;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-06-02 02:15
 **/
public class Test {

    /**
     * 方法功能：对单链表进行逆序
     * 输入参数：head:链表头结点
     * @param head
     */
    public static void Reverse(ListNode head) {
        // 判断链表是否为空
        if (head == null || head.next == null) {
            return;
        }
        ListNode pre = null; // 前驱结点
        ListNode cur = null; // 当前结点
        ListNode next = null; // 后继结点
        // 把链表首结点变为尾结点
        cur = head.next;

    }

    public static void main(String[] args) {

    }

}
