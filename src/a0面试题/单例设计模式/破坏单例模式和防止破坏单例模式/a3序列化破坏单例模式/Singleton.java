package a0面试题.单例设计模式.破坏单例模式和防止破坏单例模式.a3序列化破坏单例模式;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = -4264591697494981165L;

    // 静态内部类
    private static class SingletonHolder {
        private static final  Singleton INSTANCE = new Singleton();
    }

    // 私有的构造方法
    private Singleton() {
        // 防止反射创建多个对象
        if(SingletonHolder.INSTANCE != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    // 公有的获取实例方法
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
