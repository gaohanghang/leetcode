package a0面试题.多线程.java多线程之线程创建的4种方式.a1;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-18 12:01
 **/
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("子线程" + Thread.currentThread().getName() + "正在执行 ");
    }

}
