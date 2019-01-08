package a0算法面试题.动态规划;

/**
 * @Description: 求不相邻元素的和的最优解 15
 * @author: Gao Hang Hang
 * @date 2019/01/06 20:50
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 9, 1};
        int i = new Test().dpOpt(arr);
        System.out.println(i);
    }

    // 递归最优解
    public int recOpt(int[] arr,int i) {
        if (i == 0) return arr[0];
        else if (i == 1) return Math.max(arr[0], arr[1]);
        else {
            int a = recOpt(arr, i - 2) + arr[i];
            int b = recOpt(arr, i - 1);
            return Math.max(a, b);
        }
    }

    // 动态规划求最优解
    public int dpOpt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int A = opt[i - 2] + arr[i];
            int B = opt[i - 1];
            opt[i] = Math.max(A, B);
        }
        return opt[arr.length -1];
    }
}
