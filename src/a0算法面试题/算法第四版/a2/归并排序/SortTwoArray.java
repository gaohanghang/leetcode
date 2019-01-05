package a0算法面试题.算法第四版.a2.归并排序;

import java.util.Arrays;

/**
 * 题目：有两个有序数组a,b,现需要将其合并成一个新的有序数组。
 * 归并排序思想
 * @author: Gao Hang Hang
 * @date 2019/01/04 18:35
 */
public class SortTwoArray {
    public static void main(String[] args) {
        int[] a = {12, 32, 63, 84, 105};
        int[] b = {12, 32, 53, 74, 95};
        int[] sort = sort(a, b);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i=0,j=0,k=0;
        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]){
                c[k++] = b[j++];
            } else {
                c[k++] = a[i++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }



}
