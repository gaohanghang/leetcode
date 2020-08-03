package a0算法面试题.单例设计模式.单例模式的七种写法2.a1;

/**
 * @Description 懒汉式 线程不安全
 * @Author Gao Hang Hang
 * @Date 2020-08-03 11:28
 **/
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton Singleton() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
