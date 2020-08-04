package a0算法面试题.单例设计模式.单例模式的七种写法.a7;

/**
 * @Description 双重校验锁
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:19
 **/
public class Singleton {

    /*
        volatile 修饰，
        singleton = new Singleton() 可以拆解为3步：
        1、分配对象内存(给singleton分配内存)
        2、调用构造器方法，执行初始化（调用 Singleton 的构造函数来初始化成员变量）。
        3、将对象引用赋值给变量(执行完这步 singleton 就为非 null 了)。
        若发生重排序，假设 A 线程执行了 1 和 3 ，还没有执行 2，B 线程来到判断 NULL，B 线程就会直接返回还没初始化的 instance 了。

        volatile 可以避免重排序。
     */
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        // 这里的 if 判断作用：减少除了初始化时之外的所有锁获取等待过程，从而减少性能开销
        if (singleton == null) {
            // 这里的 if 判断作用： 避免生成多个对象实例
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
