package a414_第三大的数;

/**
 * @Description  https://www.youtube.com/watch?v=w9cO6q5GO84
 * @Author Gao Hang Hang
 * @Date 2019-10-15 21:31
 **/
public class Solution {
    public int thirdMax(int[] nums) {
        // 存储最大
        Integer max1 = null;
        // 存储第二大
        Integer max2 = null;
        // 存储第三大
        Integer max3 = null;
        for (Integer num : nums) {
            // 去重，如果已经存在就跳过
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            // 先比较最大的，成功就把值向后传递，把第三大的丢掉       当 max1 == null 时直接将 num 赋值给 最大值max1
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) { // 第一个判断没中，判断是不是第二大的，注意值不能等于最大，这是为了防止重复  当 max2 == null 时直接将 num 赋值给 第二大值 max2
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) { // 同上    当 max3 == null 时直接将 num 赋值给 第三大值 max3
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3; // 判断第三大的数存不存在, 不存在返回最大数.
    }

    public static void main(String[] args) {
        new Solution().thirdMax(new int[]{3,2,1});
    }
}
