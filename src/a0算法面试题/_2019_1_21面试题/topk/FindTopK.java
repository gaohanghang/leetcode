package a0算法面试题._2019_1_21面试题.topk;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/21 21:04
 */
public class FindTopK {

    public static int findTopK(int[] a, int lo, int hi, int k) {
        int index = -1;
        if (lo < hi) { // 如果lo < hi直接返回-1
            int j = partition(a, lo, hi);
            int len = j - lo + 1;
            if (len == k) {
                index = j;
            } else if (len < k) { // Sa中元素个数小于K，到Sb中查找k-len个数字
                index = findTopK(a, j + 1, hi, k - len);
            } else { //Sa中元素的个数大于或等于k
                index = findTopK(a, lo, j - 1, k);
            }
        }
        return index;
    }

    /**
     * 按切分元素划分数组，左边的元素大于切分元素，右边的元素小于切分元素
     */
    public static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo];          // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(v, a[++i])) if (i == hi) break;
            while (less(a[--j], v)) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);         // 将v = a[j]放入正确的位置
        return j;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26, 100};
        int k = 100;
        findTopK(a, 0, a.length - 1, k);
        show(a);
    }
}
