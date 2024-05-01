package a1_两数之和.a2021_8_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2021-08-03 02:43
 **/
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (hashMap.containsKey(another)) {
                return new int[]{hashMap.get(another), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
