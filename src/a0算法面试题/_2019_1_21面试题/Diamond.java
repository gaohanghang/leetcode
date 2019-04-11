package a0算法面试题._2019_1_21面试题;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/21 23:00
 */
public class Diamond {
    public static void main(String[] args) {
        print(7);
    }

    // 7 / second = 3

    public static void print(int n) {
        n = n / 2; // 3
        for (int i = 1; i <= n + 1; i++) { // 上半部分
            for (int j = 1; j < n - i + 1; j++) { // 打印空格
                System.out.printf(" ");
            }
            for (int j = 1; j <= (2*i -1); j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
