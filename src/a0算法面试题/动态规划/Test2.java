package a0算法面试题.动态规划;


/**
 * arr = {3, 34, 4, 12, 5, 2}
 * S = 9 true
 * 递归
 *
 * 出口条件
 * if S == 0
 *  return true
 * if i == 0
 *  return arr[0] == S
 * if arr[i] > S
 *  return Subset(arr, i-1, S)
 *
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/06 21:16
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        boolean b = new Test2().recSubset(arr, arr.length - 1, 13);
        System.out.println(b);
    }

    public boolean recSubset(int[] arr, int i, int s) {
        if (i == 0) {
            return true;
        } else if (i == 0) {
            return arr[i] == s;
        } else if (arr[i] > s) {
            return recSubset(arr, i - 1, s);
        } else {
            boolean A = recSubset(arr, i - 1, s - arr[i]);
            boolean B = recSubset(arr, i - 1, s);
            return A | B;
        }
    }
}
