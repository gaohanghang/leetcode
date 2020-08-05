package a0算法面试题.单例设计模式.单例模式的七种写法2.a4;

/**
 * @Description 4 饿汉式 变种
 * @Author Gao Hang Hang
 * @Date 2020-08-04 23:28
 **/
public class Singleton {

    private static Singleton instance = null;

    static {
        instance = new Singleton();
    }

    private Singleton(){
    }

    public static Singleton getInstance(){
        return instance;
    }

}
