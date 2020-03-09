package a137_只出现一次的数字II;

import java.util.HashMap;

/**
 * @Description 方法二：HashMap
 * @Author Gao Hang Hang
 * @Date 2020-03-08 13:57
 **/
public class Solution2 {

    /*
       - 时间复杂度：O(N)，遍历输入数组。
       - 空间复杂度：O(N)，存储 N/3 个元素的 Set。
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (int k : hashMap.keySet()) {
            if (hashMap.get(k) == 1) {
                return k;
            }
        }
        return -1;
    }

}
