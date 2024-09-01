package a0面试题.面试题16_6最小差;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-08-30 19:12
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        long min = Long.MAX_VALUE;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) return 0;
            else if (a[i] > b[j]) {
                min = Math.min(min,(long) a[i] -(long) b[j]);
                j++;
            } else {
                min = Math.min(min,(long) b[j] -(long) a[i]);
                i++;
            }
        }

        return (int) min;
    }
}
