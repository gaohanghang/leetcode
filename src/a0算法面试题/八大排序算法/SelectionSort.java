package a0算法面试题.八大排序算法;

/**
 * @Description: 选择排序
 * @author: Gao Hang Hang
 * @date 2019/01/02 12:31
 */
public class SelectionSort {
    public static int[] electionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // 找到最小的数
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
