package a167_两数之和2_输入有序数组;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/11 22:09
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i;
            int high = numbers.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int midVal = numbers[mid];

                int num2 = target - numbers[i];

                if (num2 == midVal && i != mid) {
                    return new int[]{i+1, mid + 1};
                } else if (num2 > midVal) {
                    low = mid + 1;
                } else if (num2 < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return null;
    }
}
