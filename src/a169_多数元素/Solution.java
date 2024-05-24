package a169_多数元素;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-05-24 16:27
 **/
public class Solution {

    // time：O(nlogn) space：O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // time：O(n) space: O(n)
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }

            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }

    //
}
