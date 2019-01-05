package a0算法面试题.算法第四版.a2.归并排序;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/04 19:12
 */
public class Test2 {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] c = new int[m+n];
        int i=0,j=0,k=0;
        while(i < m && j < n) {
            if(nums1[i] >= nums2[j]) {
                c[k++] = nums2[j++];
            } else {
                c[k++] = nums1[i++];
            }
        }

        while (j < n) {
            c[k++] = nums2[j++];
        }
        System.arraycopy(c,0, nums1, 0,m+n);
        System.out.println(Arrays.toString(nums1));
    }
}
