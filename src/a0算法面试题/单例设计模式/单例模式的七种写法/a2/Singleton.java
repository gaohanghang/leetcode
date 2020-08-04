package a0算法面试题.单例设计模式.单例模式的七种写法.a2;

/**
 * @Description 懒汉式 ， 线程安全
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:10
 **/
public class Singleton {

    /*
        这里用 static 是因为 getInstance() 方法是静态的，而静态方法不能访问非静态成员变量，所以 instanc 必须是静态成员变量

        getInstance() 方法是静态是因为构造器是私有的，只能通过 Singleton.getInstance() 方法获取对象实例

        构造器是私有是为了防止其他类通过 new Singleton() 来创建对象实例
     */
    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 使用 synchronize 关键字对方法加锁，确保任意时刻都只有一个线程可以执行该方法
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
