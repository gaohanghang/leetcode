package a4_寻找两个有序数组的中位数;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-16 01:22
 **/
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n +1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]) {
                iMin = i+1; // i is too small
            } else if (i > iMin && A[i-1] > B[j]) {
                iMax = i + 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]};
            }
        }
    }
}
