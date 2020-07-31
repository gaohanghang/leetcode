package a0算法面试题.单例设计模式.单例模式的七种写法.a2020_7_30;


/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-30 00:08
 **/
public class Singleton {

    private volatile static Singleton singleton; // volatile防止指令重排序，内存可见(缓存中的变化及时刷到主存，并且其他的内存失效，必须从主存获取)

    private Singleton() {
    }

    public static Singleton getSingleton() {
        // 减少除了初始化时之外的所有锁获取等待过程，从而减少性能开销
        if (singleton == null) { // C E F G
            synchronized (Singleton.class) { // A B
                if (singleton == null) { // 避免生成多个对象实例
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
