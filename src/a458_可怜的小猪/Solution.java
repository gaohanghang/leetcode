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
        // base ^ ans >= buckets
        // ans >= log(buckets) / log(base)
        double temp = Math.log(buckets) / Math.log(base);
        int ans = (int) Math.ceil(temp);
        return ans;
    }
}
