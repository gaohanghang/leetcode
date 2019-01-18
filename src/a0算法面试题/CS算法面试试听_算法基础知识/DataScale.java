package a0算法面试题.CS算法面试试听_算法基础知识;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/17 23:30
 */
public class DataScale {

    public static void dataScale() {
        for (int i = 1; i < 10; i++) {
            double num = Math.pow(i,10);// num = 10 100 1000 ...
            int sum = 0;

            long before = System.currentTimeMillis();
            for (int j = 0; j <= num; j++) {
                sum += j;
            }
            long end = System.currentTimeMillis();

            long per = end - before;
            System.out.println("10^" + i + ": " + per);
        }
    }

    public static void main(String[] args) {
        dataScale();
    }
}
