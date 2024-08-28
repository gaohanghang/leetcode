package a0面试题.面试题17_14最小K个数;

import java.util.Arrays;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }
}
