package a134_加油站;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2021-10-25 08:22
 **/
public class Solution {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int i = new Solution().canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //首先计算总油量与总消耗量的差值
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        //如果差值小于0，则无解
        if (sum < 0) {
            return -1;
        }
        //记录油箱中的油量
        int tank = 0;
        //记录起点
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            //如果油箱中油量小于0，则从下一个加油站重新开始
            if (tank < 0) {
                //小于0，说明无法从 start 走到i,中间的作为起点也都不成立
                tank = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
