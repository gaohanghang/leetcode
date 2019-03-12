package a167_两数之和2_输入有序数组;

/**
 * @Description: 双指针法
 * @author: Gao Hang Hang
 * @date 2019/03/11 22:19
 */
public class Solution2 {
    /*
        指针 i 指向最左端，从左到右依次循环
        指针 j 指向最右端，从右到左依次循环
            total = numers[i] + numbers[j]
            total == sum：得到结果
            total > sum: j = j - 1，使 total 值减小
            total < sum: i = i + 1, 使得 total 值增大
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else { // numbers[i] + numbers[j] == target
                break;
            }
        }
        arr[0] = i + 1;
        arr[1] = j + 1;
        return arr;
    }
}
