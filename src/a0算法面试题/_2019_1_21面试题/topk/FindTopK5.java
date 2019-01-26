package a0算法面试题._2019_1_21面试题.topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/26 19:18
 */
public class FindTopK5 {
    /*
        TOP-K问题是一个经典的问题，这个问题是存在线性算法的，只不过算法的使用范围有一定的限制。
        如果所有N个数都是正整数，且他们的取值范围并不大，可以考虑申请空间，记录每个整数出现的次数，然后再从大到小取最大的K个。
        实际就是利用计数排序的思想。 假设所有整数都在（0，maxN）区间，利用一个数组count[maxN]来记录每个整数出现的次数。count[i]表示整数i在N个数中出现的次数。只需要扫描一遍就可以得到count数组，然后寻找第K大的元素。算法实现如下：

        这是一个典型的以空间换取时间的做法。当数组中取值范围比较大时，是及其浪费空间的。如[3,1...9999]，为了求出最大的K个元素，需要额外申请一个长度为10000的数组。

        极端情况下，如果 N 个整数各不相同，我们甚至只需要一个 bit (0,1) 来存储这个整数是否存在，这样可节省很大的内存空间。
     */
    
    public static List<Integer> findTopK(int[] array, int k) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int count[] = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]] += 1;
        }
        List<Integer> topKList = new ArrayList<>();
        for (int sumCount = 0,j = count.length - 1; j >= 0; j--) {
            int c = count[j];
            sumCount += c;
            if (c > 0) {
                for (int i = 0; i < c; i++) { // 如果c = 2 比如100有两个说明，要add两次
                    topKList.add(j);
                }
            }
            if (sumCount >= k) {
                break;
            }
        }
        return topKList;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
        List<Integer> topK = findTopK(a, k);
        System.out.println(topK);
    }
}
