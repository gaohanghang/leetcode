package a0算法面试题.单例设计模式.单例模式的七种写法2.a5;

/**
 * @Description 5 静态内部类
 * @Author Gao Hang Hang
 * @Date 2020-08-06 10:41
 **/
public class Singleton {

    private Singleton(){
    }

    private static class SingletonHolder{
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
