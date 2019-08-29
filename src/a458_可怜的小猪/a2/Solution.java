package a458_可怜的小猪.a2;

import java.util.Map;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-28 20:23
 **/
public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 60 / 15 = 4
        int times = minutesToTest / minutesToDie;
        int base = times + 1;
        // base ^ ans >= buckets
        double temp = Math.log(buckets) / Math.log(base);
        // 取整数部分
        int ans = (int) Math.ceil(temp);
        return ans;
    }
}
