package a0面试题.多线程.java多线程之线程创建的4种方式.a2;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-18 12:05
 **/
public class Test {

    public static void main(String[] args) {
        ImpRunnableThread t = new ImpRunnableThread();
        Thread thread = new Thread(t);
        thread.start();
    }

}
