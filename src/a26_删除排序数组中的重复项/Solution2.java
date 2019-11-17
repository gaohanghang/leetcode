package a26_删除排序数组中的重复项;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-11-17 19:54
 **/
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = new Solution2().removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            /*
                当我们遇到 nums[j] != nums[i] 时，跳过重复项的运行已经结束，
                因此我们必须把它（nums[j]）的值复制到 nums[i+1]。然后递增 i
             */
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
