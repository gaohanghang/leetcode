package a0面试题.多线程.java多线程之线程创建的4种方式.a1;

/**
 * @Description 使用匿名类的方式创建
 * @Author Gao Hang Hang
 * @Date 2020-08-18 12:02
 **/
public class Test2 {

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
    }

}
