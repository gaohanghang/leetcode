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


        这里用 static 是因为 getInstance() 方法是静态的，而静态方法不能访问非静态成员变量，所以 instance 必须是静态成员变量

        getInstance() 方法是静态是因为构造器是私有的，只能通过 Singleton.getInstance() 方法获取对象实例

        构造器是私有是为了防止其他类通过 new Singleton() 来创建对象实例
     */
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        // 这里的 if 判断作用：检查实例是否存在，如果存在即可返回，不存在则进入同步块，减少除了初始化时之外的所有锁获取等待过程，从而减少性能开销
        if (singleton == null) { // C E F G
            synchronized (Singleton.class) { // A B
                // 这里的 if 判断作用： 避免生成多个对象实例
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
