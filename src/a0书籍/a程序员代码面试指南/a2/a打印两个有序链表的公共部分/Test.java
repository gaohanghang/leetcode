package a0书籍.a程序员代码面试指南.a2.a打印两个有序链表的公共部分;

/**
 * 1 3 5 6
 * 2 5 6
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-06-22 20:16
 **/
public class Test {

    public static void main(String[] args) {

    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

}
