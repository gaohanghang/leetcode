package a349_两个数组的交集;

import java.util.HashSet;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/14 09:05
 */
public class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) output[idx++] = s;
        return output;
    }
}
