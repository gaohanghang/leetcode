package a0面试题.单例设计模式.threadlocal实现;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-13 20:03
 **/
public class Singleton {

    private static final ThreadLocal<Singleton> singleton = new ThreadLocal<Singleton>() {
        @Override
        protected Singleton initialValue() {
            return new Singleton();
        }
    };

    // 私有化构造器
    private Singleton(){
    }

    // 获取实例的方法
    public static Singleton getInstance() {
        return singleton.get();
    }

}
