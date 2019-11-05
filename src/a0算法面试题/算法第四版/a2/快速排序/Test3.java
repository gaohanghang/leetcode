package a0算法面试题.算法第四版.a2.快速排序;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-11-02 17:45
 **/
public class Test3 {

    public static void main(String[] args) {
        new Test().sort(new int[]{1,7,8,3,1,2});
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // 切分
        // 将左半部分a[lo .. j-1]排序
        sort(a, lo, j - 1);
        // 将右半部分a[j+1 .. hi]排序
        sort(a, j + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo.. i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo]; // 切分元素
        while (true) {
            // 扫描左右，扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, --j)) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        // 将 v = a[j] 放入正确的位置
        exch(a, lo, j);
        // a[lo..j-1] <= a[j+1..hi]达成
        return j;
    }

    // 对元素进行比较
    private boolean less(int v, int w) {
        return v < w;
    }

    // 对元素进行交换
    private void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
