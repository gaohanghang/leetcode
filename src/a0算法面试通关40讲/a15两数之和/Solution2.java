package a0算法面试通关40讲.a15两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/02/25 20:00
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // 将数组存入 hashmap
        for (int i = 0; i < nums.length; i++) {
            // 值为 key, 索引为 value
            map.put(nums[i], i);
        }

        // 遍历数组的每一个元素
        for (int i = 0; i < nums.length; i++) {
            // 计算需要从 hashmap 里面找出的元素
            int complement = target - nums[i];
            // 判断 hashmap里面是否存在该元素，并且该元素不能与当前 nums[i]是一个元素
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] ints = solution2.twoSum(new int[]{2, 3, 4, 5}, 7);
        System.out.println(Arrays.toString(ints));
    }
}
