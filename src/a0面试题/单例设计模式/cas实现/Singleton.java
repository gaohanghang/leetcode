package a0面试题.单例设计模式.cas实现;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-22 15:40
 **/
public class Singleton {

    // AtomicReference 提供了可以原子的读写对象引用的一种机制
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();

    // 私有化构造器
    private Singleton() {
    }

    // 获取实例的 getInstance() 方法
    public static Singleton getInstance() {
        for(;;) {
            // 从 INSTANCE中 获取实例
            Singleton singleton = INSTANCE.get();
            // 如果实例不为空就返回
            if (null != singleton) {
                return singleton;
            }
            // 实例为空就创建实例
            singleton = new Singleton();
            // compareAndSet() 主要的作用是通过比对两个对象，然后更新为新的对象
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

}
