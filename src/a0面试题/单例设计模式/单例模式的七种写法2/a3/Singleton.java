package a0面试题.单例设计模式.单例模式的七种写法2.a3;

/**
 * @Description 3 饿汉式
 * @Author Gao Hang Hang
 * @Date 2020-08-04 22:56
 **/
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}
