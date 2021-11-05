package a0面试题.多线程.多线程将10万个数字转换为字符串;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 多线程将10万个数字转换为字符串
 * @Author Gao Hang Hang
 * @Date 2020-07-29 22:27
 **/
public class Test {

    static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int number = i;
            fixedThreadPool.execute(() -> {
                String s = intToString(number);
                System.out.println(s);
            });
        }
    }

    public static String intToString(int a) {
        return String.valueOf(a);
    }

}
