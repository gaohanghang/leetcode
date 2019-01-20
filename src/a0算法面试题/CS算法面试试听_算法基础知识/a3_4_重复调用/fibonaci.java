package a0算法面试题.CS算法面试试听_算法基础知识.a3_4_重复调用;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/18 13:31
 */
public class fibonaci {
    static int count = 0;

    public static int fibonaci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            count++;
            for (int i = 0; i < count; i++) {
                System.out.print("-");
            }
            System.out.println(num);
            return fibonaci(num - 1) + fibonaci(num - 2);
        }
    }

    static int max = Integer.MAX_VALUE;

    static int[] memorization = new int[600];

    public static int fibonaci2(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        if (memorization[num] == 0) {
            memorization[num] = fibonaci2(num - 1) + fibonaci2(num - 2);
        }
        return memorization[num];
    }

    public static void main(String[] args) {
        System.out.println(fibonaci2(6));
    }
}
