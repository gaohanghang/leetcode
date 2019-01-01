package a88_合并两个有序数组;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 15:11
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) nums1[m + i] = nums2[i];
        Arrays.sort(nums1);
    }
}
