package a137_只出现一次的数字II;

/**
 * @Description 方法三：位运算符：NOT，AND 和 XOR
 * @Author Gao Hang Hang
 * @Date 2020-03-08 14:06
 **/
public class Solution3 {

    public static void main(String[] args) {
        int[] nums =new int[]{2,2,3,2};
        Solution solution = new Solution();
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }

    /*
       时间复杂度：O(N)，遍历输入数组
       空间复杂度：O(1)，不适用额外空间

       0 -> 1 -> 2 -> 0
       00 -> 00 -> 10 -> 00
       00-> 10 -> 01 -> 00
     */
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);;
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

}
