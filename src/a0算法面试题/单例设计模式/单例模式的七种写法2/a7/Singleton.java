package a0算法面试题.单例设计模式.单例模式的七种写法2.a7;

/**
 * @Description 7 双重校验锁
 * @Author Gao Hang Hang
 * @Date 2020-08-05 00:04
 **/
public class Singleton {

    private volatile static Singleton instance;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
