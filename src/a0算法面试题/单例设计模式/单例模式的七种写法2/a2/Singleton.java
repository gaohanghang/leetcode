package a0算法面试题.单例设计模式.单例模式的七种写法2.a2;

/**
 * @Description 2. 懒汉式，线程安全
 * @Author Gao Hang Hang
 * @Date 2020-08-04 21:54
 **/
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
