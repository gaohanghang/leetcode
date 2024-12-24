package a0算法面试题.八大排序算法.a6_冒泡排序;

import java.util.Arrays;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-12-20 13:59
 **/
public class BubbleSort2 {

    public static void main(String[] args) {
        int[] ints = bubbleSort(new int[]{4, 5, 3, 2});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] bubbleSort(int[] arr) {
        // 外层循环控制排序趟数
        for (int i = 0; i < arr.length -1; i++) {
            // 内层循环控制
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
