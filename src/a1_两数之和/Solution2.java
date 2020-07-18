package a1_两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1. 两数之和
 * @author: Gao Hang Hang
 * @date 2018/12/26 11:33
 */
public class Solution2 {

    //方法二：两遍哈希表 时间复杂度 O(n) 空间复杂度 O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{ i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
