package a0算法面试题.八大排序算法.a6_冒泡排序;

import java.util.Arrays;

/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 18:18
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = bubbleSort2(new int[]{4, 5, 3, 2});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] bubbleSort(int[] nums) {
        int temp = 0;
        int size = nums.length;
        for (int i = 0; i < size -1; i++) { //
            for (int j = 0; j < size - 1 - i; j++) {
                if (nums[j] > nums[j+1]) { // 交换两数的位置
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    // 冒泡排序
    public static int[] bubbleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j +1]) { // 交换两数的位置
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}
