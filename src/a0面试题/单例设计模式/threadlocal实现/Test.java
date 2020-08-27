package a0面试题.单例设计模式.threadlocal实现;


/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-07 16:40
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println("main thread "+Singleton.getInstance());
        System.out.println("main thread "+Singleton.getInstance());
        System.out.println("main thread "+Singleton.getInstance());

        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + Singleton.getInstance());
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + Singleton.getInstance());
            }
        });
        thread0.start();
        thread1.start();
    }
}
