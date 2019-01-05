package a0算法面试题.算法第四版.a2.归并排序;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/04 18:12
 */
public class Sort {

    public static void MergeSort(int[] arr, int low, int high) {
        // 使用递归的方式进行归并排序，所需要的空间复杂度是O(NlogN)
        int mid = (low + high) / 2;
        if (low < high) {
            // 递归地对左右两边进行排序
            MergeSort(arr, low, high);
            MergeSort(arr, mid + 1, high);
            // 合并
        }
    }

    // merge函数实际上是讲两个有序数组合并成一个有序数组
    // 因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high) {
        // temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        // 左半边的指针
        int i = low;
        // 右半边的指针
        int j = mid + 1;
        // 合并后数组的指针
        int k = 0;

        // 将记录由小到大放进temp数组
        while (i <= mid && j <= high) {

        }
    }

}
