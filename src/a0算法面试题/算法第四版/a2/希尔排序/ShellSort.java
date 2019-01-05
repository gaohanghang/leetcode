package a0算法面试题.算法第四版.a2.希尔排序;

import java.util.Arrays;

/**
 * 希尔排序:依次改变缩量的插入排序
 * 重复做的事：改变缩量，从无序序列中选择第一个元素
 *
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/05 16:06
 */
public class ShellSort {
    public static void main(String[] args) {
        shellSort(new int[]{1, 8, 9, 2, 4});
    }

    public static void shellSort(int[] a) {
        int h = 1;
        // 根据条件获取最大h
        while (h < a.length / 3) h = h * 3;
        // 缩小h并重复排序算法
        while (h >= 1) {
            // 拿出 h 之后的元素作为插入元素
            for (int i = h; i < a.length; i++) {
                // 与前面 h 个位置的元素交换位置知道找到一个小于当前值的元素
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }
                }
            }
            h = h / 3;
        }
    }
}
