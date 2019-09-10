package a0算法面试题.单例设计模式.单例模式的七种写法.a3;

import edu.princeton.cs.algs4.StdIn;

/**
 * @Description (饿汉式)
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:12
 **/
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
