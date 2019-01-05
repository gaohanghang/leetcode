package a0算法面试题.算法第四版.a2.归并排序;

/**
 * @Description: 自底向上的归并排序
 * @author: Gao Hang Hang
 * @date 2019/01/05 21:31
 */
public class Test3 {
    public static void main(String[] args) {

    }

    private int[] aux;      // 归并所需的辅助数组


    private boolean less(int v, int w) {
        return v < w;
    }

    private void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void show(int[] a) {   // 在单行打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private boolean isSorted(int[] a) {   // 测试数组是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
