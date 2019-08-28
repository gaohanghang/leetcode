package a458_可怜的小猪;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-08-19 18:50
 **/
public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 60 / 15 = 4
        int times = minutesToTest / minutesToDie;
        // base = 5
        int base = times + 1;
        // base ^ ans >= buckets    5 ^ ans >= 25
        // ans >= log(buckets) / log(base) ans >= log(25) / log(5)
        double temp = Math.log(buckets) / Math.log(base);
        // ceil 则是不小于他的最小整数 ceil(1.2) 2
        int ans = (int) Math.ceil(temp);
        return ans;
    }
}
