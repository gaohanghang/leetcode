package a0面试题.多线程.java多线程之线程创建的4种方式.a2;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-18 12:05
 **/
public class Test2 {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable running");
            }
        });
        t.start();
    }

}
