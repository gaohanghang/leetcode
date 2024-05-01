package a1_两数之和.a2021_8_3;


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
        //int target = 9;
        int target = 18;

        // 测试
        //Solution solution = new Solution();
        //int[] result = solution.twoSum(nums, target);
        //System.out.println(Arrays.toString(result));
        //
        //Solution2 solution2 = new Solution2();
        //int[] result2 = solution2.twoSum(nums, target);
        //System.out.println(Arrays.toString(result2));

        Solution3 solution3 = new Solution3();
        int[] result3 = solution3.twoSum(nums, target);
        System.out.println(Arrays.toString(result3));
    }

}
