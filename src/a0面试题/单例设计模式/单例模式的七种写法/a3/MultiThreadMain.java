package a0面试题.单例设计模式.单例模式的七种写法.a3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-07 16:40
 **/
public class MultiThreadMain {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" +Singleton.getInstance());
                }
            });
        }

        threadPool.shutdown();

    }
}
