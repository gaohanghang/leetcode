package a1_两数之和.a2025_1_14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2025-01-14 20:29
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
