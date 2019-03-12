package a167_两数之和2_输入有序数组;

/**
 * @Description: 暴力法
 * @author: Gao Hang Hang
 * @date 2019/03/11 22:25
 */
public class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j]) == target) {
                    return new int[]{++i,++j};
                }
            }
        }
        return null;
    }
}
