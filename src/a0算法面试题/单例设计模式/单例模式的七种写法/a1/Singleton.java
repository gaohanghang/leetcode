package a0算法面试题.单例设计模式.单例模式的七种写法.a1;

/**
 * @Description (懒汉式 ， 线程不安全)
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:07
 **/
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
