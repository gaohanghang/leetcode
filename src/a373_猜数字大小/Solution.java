package a373_猜数字大小;


public class Solution {
    /**
     * 猜数字游戏，我们是猜测的一方
     *
     * 解题思路：注意理解题意即可，我们以范围 1- 10，系统猜测的数据为 6 为例，循环证明过程如下
     *
     * min max result
     *  1   10   5
     *  6   10   8
     *  6    7   6
     *
     * 证明结束
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        int result;
        int flag;
        do {
            // 此处要避免数据溢出，不能写 (max + min) / 2
            result = min + (max - min) / 2;
            flag = guess(result);
        } while(flag!=0);
        return result;
    }

    private int guess(int result) {
        return 0;
    }
}
