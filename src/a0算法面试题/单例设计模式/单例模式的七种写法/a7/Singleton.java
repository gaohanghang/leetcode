package a0算法面试题.单例设计模式.单例模式的七种写法.a7;

/**
 * @Description (双重校验锁)
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:19
 **/
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
