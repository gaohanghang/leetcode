package a198_打家劫舍;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-11-08 12:51
 **/
public class Solution {

    /**
     *
     [1, 3, 2, 4, 1]

     */
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int num : nums) {
            int temp = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        return prevYes;
    }

}
