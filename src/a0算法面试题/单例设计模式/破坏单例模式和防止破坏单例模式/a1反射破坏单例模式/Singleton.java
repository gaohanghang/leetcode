package a0算法面试题.单例设计模式.破坏单例模式和防止破坏单例模式.a1反射破坏单例模式;

public class Singleton {

    // 静态内部类
    private static class SingletonHolder {
        private static final  Singleton INSTANCE = new Singleton();
    }

    // 私有的构造方法
    private Singleton() {
    }

    // 公有的获取实例方法
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
