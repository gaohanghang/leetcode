package a0算法面试题.数组.数组中差值的最大值;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description 数组中差值的最大值
 * @date 2024-09-14 14:03
 **/
public class Solution {
    public static void main(String[] args) {
        int[] records={370,400,420,390,350,430,400};
        int[] records2={300,400,420,490,550,551,600};
        int maxSubNum = getMaxSubNum(records);
        System.out.println(maxSubNum);

        int maxSubNumIndex = getMaxSubNumIndex(records);
        System.out.println(maxSubNumIndex);
    }

    public static int getMaxSubNum(int[] records) {
        int maxSubNum = 0;
        for (int i = 0; i < records.length - 1; i++) {
            for (int j = i + 1; j < records.length; j++) {
                if(records[i] > records[j]) {
                    maxSubNum = Math.max(maxSubNum, records[i] - records[j]);
                }
            }
        }
        return maxSubNum;
    }

    public static int getMaxSubNumIndex(int[] records) {
        int maxSubNum = 0;
        int left = 0;
        int right = 1;
        while (right < records.length) {
            if (records[left] < records[right]) {
                left++;
            } else {
                maxSubNum = Math.max(maxSubNum, records[left] - records[right]);
                right++;
            }
        }
        return maxSubNum;
    }
}
