package a137_只出现一次的数字II;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 方法一：HashSet
 * @Author Gao Hang Hang
 * @Date 2020-03-08 13:32
 **/
public class Solution {

    public static void main(String[] args) {
        int[] nums =new int[]{2,2,3,2};
        Solution solution = new Solution();
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }

    /*
    方法一：HashSet
    将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
    3×(a+b+c)−(a+a+a+b+b+b+c)=2c

    - 时间复杂度：O(N)，遍历数据数组
    - 空间复杂度：O(N)，存储 N/3 个元素的集合
     */
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for (int n : nums) {
            sumArray += n;
            set.add((long) n);
        }
        for (Long s : set) {
            sumSet += s;
        }
        // sumSet 5    sumArray 9
        // (15 - 9) / 2 = 3
        // 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
        return (int)(3 * sumSet - sumArray) / 2;
    }

}
