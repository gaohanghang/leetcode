package a1_两数之和;

import java.util.Arrays;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-18 18:52
 **/
public class Test {

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {2, 7, 11, 15};

        // 测试
        Solution solution = new Solution();
        int[] ints = solution.towSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

}
