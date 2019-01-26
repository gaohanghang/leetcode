package a0算法面试题._2019_1_21面试题.topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/26 18:10
 */
public class FindTopK3 {

    /*
        解法三
        寻找Ｎ个数中的第Ｋ大的数，可以将问题转化寻找Ｎ个数中第K大的问题。对于一个给定的数p， 可以在O(N)的时间复杂度内找出所有不小于P的数。

        根据分析，可以使用二分查找的算法思想来寻找Ｎ个数中第K大的数。假设N个数中最大的数为Vmax，最小的数为Vmin, 那么Ｎ个数中第K大的数一定在区间[Vmin,Vmax]之间。然后在这个区间使用二分查找算法。算法实现如下：

        总结：该算法实际应用效果不佳，尤其是不同的数据类型需要确定max - min > delta，因此时间复杂度跟数据分布有关。 整个算法的时间复杂度为O(N * log（Vmax-Vmin）/delta)，在数据分布平均的情况下，时间复杂度为O(N * logN)。
     */
    public static List<Integer> findTopK(int[] a, int k) {
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            if (min > a[i]) {
                min = a[i];
            }
        }
        List<Integer> topKList = new ArrayList<>();
        int key = findK(a, max, min, k); // 找到第k大元素
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= key) {
                topKList.add(a[i]);
            }
        }
        return topKList;
    }

    /**
     * 寻找第K大的元素
     *
     * @param array
     * @param max
     * @param min
     * @param k
     * @return
     */
    private static int findK(int[] array, int max, int min, int k) {
        while (max - min > 1) {
            int mid = (max + min) / 2;
            int num = findKNum(array, mid);
            if (num >= k) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }

    /**
     * 统计不小于key的元素个数
     *
     * @param array
     * @param key
     * @return
     */
    private static int findKNum(int[] array, int key) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= key) sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
        List<Integer> topK = findTopK(a, k);
        System.out.println(topK);
    }
}
