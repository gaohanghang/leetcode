package a179_最大数;

import java.util.Arrays;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-08-28 22:23
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,30,34,5,9};
        String s = solution.largestNumber(nums);
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));

        if(strs[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
