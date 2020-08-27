package a0面试题.单例设计模式.单例模式的七种写法.a4;

/**
 * @Description 饿汉，变种
 * 表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance。
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:14
 **/
public class Singleton {

    /*
        这里用 static 是因为 getInstance() 方法是静态的，而静态方法不能访问非静态成员变量，所以 instanc 必须是静态成员变量

        getInstance() 方法是静态是因为构造器是私有的，只能通过 Singleton.getInstance() 方法获取对象实例

        构造器是私有是为了防止其他类通过 new Singleton() 来创建对象实例
     */
    private static Singleton instance = null;

    static {
        instance = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

}
