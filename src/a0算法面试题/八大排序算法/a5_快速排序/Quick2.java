package a0算法面试题.八大排序算法.a5_快速排序;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-12-24 19:48
 **/
public class Quick2 {
    public static void main(String[] args) {
        int[] a = {5, 6, 9, 1, 2, 3};
        sort(a);
        show(a);
    }

    private static void show(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void sort(int[] a) {
        quickSort(a, 0, a.length -1);
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        int start = low; // 从前向后比较的索引
        int end = high; // 从后向前比较的索引
        int key = arr[low]; // 基准值
        while (end > start) {
            // 从后向前比较
            while (end > start && arr[end] >= key) {
                end--;
            }
            // 如果没有比基准值小的，则比较下一个，直到有比基准值小的，则交换位置，然后又从前向后比较
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 从前向后比较
            while (end > start && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            // 此时第一次循环比较结束，基准值的位置已经确定。左边的值都比关键字小
            // 右边的值都比关键字大，但是两边的顺序还有可能不一样，接着进行下面的递归调用
        }

        // 递归左边序列：从第1个索引位置到“关键值索引-1”
        if (start > low) quickSort(arr, low, start - 1);
        if (end < high) quickSort(arr, end + 1, high);
        return arr;
    }

}
