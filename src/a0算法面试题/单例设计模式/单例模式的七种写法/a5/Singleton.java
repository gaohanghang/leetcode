package a0算法面试题.单例设计模式.单例模式的七种写法.a5;

/**
 * @Description (静态内部类)
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:16
 **/
public class Singleton {
    private static class SingletonHolder {
        private static final  Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
