# TOP-K问题的几种解法

## 解法一
最简单且最容易想到的算法是对数组进行排序（快速排序），然后取最大或最小的K个元素。总的时间复杂度为O(N*logN)+O(K)=O(N*logN)。该算法存在以下问题：

1. 快速排序的平均复杂度为O(N*logN)，但最坏时间复杂度为O(n2)，不能始终保证较好的复杂度
2. 只需要前k大或k小的数,，实际对其余不需要的数也进行了排序，浪费了大量排序时间

总结：通常不会采取该方案。

## 解法二

虽然我们不会采用快速排序的算法来实现TOP-K问题，但我们可以利用快速排序的思想，
在数组中随机找一个元素key，将数组分成两部分Sa和Sb，其中Sa的元素>=key，Sb的元素<key，然后分析两种情况：

```java
public class findTopK {

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
```
## 解法三

寻找Ｎ个数中的第Ｋ大的数，可以将问题转化寻找Ｎ个数中第K大的问题。对于一个给定的数p， 可以在O(N)的时间复杂度内找出所有不小于P的数。



