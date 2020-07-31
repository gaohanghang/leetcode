package a0算法面试题.单例设计模式.单例模式的七种写法.a4;

/**
 * @Description 饿汉，变种
 * 表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance。
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:14
 **/
public class Singleton {

    private static Singleton instance = null;

    static {
        instance = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

}
