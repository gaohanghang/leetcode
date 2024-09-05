package a0算法面试题.数组;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description 给定一个数组，要求找出将数组划分为数量在m和n之间的两个数组的k，一个数组的所有值都大于k一个数组的所有值都小于等于k，求k的最小值。
 * @date 2024-09-05 15:18
 **/
public class FindMinK {

    // 方法：寻找满足条件的最小 k
    public static int findMinK(int[] arr, int m, int n) {
        Arrays.sort(arr);

        // 二分查找的边界
        int left = 0, right = arr.length - 1;
        int result = Integer.MAX_VALUE;

        // 开始二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            int k = arr[mid];

            // 统计数组中小于等于 k 的元素数量
            int countLeft = countLessThanOrEqual(arr, k);

            // 检查是否满足 m <= countLeft <= n
            if (m <= countLeft && countLeft <= n) {
                // 如果满足条件，更新结果
                result = Math.min(result, k);
                // 继续在左边查找以寻找更小的 k
                right = mid - 1;
            } else if (countLeft < m) {
                // 如果小于等于 k 的元素数量少于 m，增加 k
                left = mid + 1;
            } else {
                // 如果小于等于 k 的元素数量多于 n，减少 k
                right = mid - 1;
            }
        }

        // 返回找到的最小 k
        return result;
    }

    // 辅助方法：统计小于等于 k 的元素个数
    private static int countLessThanOrEqual(int[] arr, int k) {
        int count = 0;
        for (int num : arr) {
            if(num <= k) {
                count++;
            } else {
                break; // 因为数组已经排过序，所以可以提前终止
            }
        }
        return count;
    }

    // 测试主方法
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int m = 3, n = 5;

        int k = findMinK(arr, m, n);
        System.out.println("最小的 k 是: " + k);
    }

}
