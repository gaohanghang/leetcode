package a0算法面试题._2019_1_21面试题.topk;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/23 16:14
 */
public class FindTopK2 {
    public static List<Integer> findTopK(int[] a, int k) {
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            if (max > a[i]) {
                min = a[i];
            }
        }
        List<Integer> topKList = new ArrayList<>();
        return null;
    }


}
