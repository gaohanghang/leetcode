package a349_两个数组的交集.a2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-08 23:25
 **/
public class Solution {
    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer n : set1)
            if (set2.contains(n)) output[idx++] = n;
        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }
}
