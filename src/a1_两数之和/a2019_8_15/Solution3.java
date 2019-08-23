package a1_两数之和.a2019_8_15;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-15 20:24
 **/
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw  new IllegalArgumentException("No two sum solution");
    }
}
