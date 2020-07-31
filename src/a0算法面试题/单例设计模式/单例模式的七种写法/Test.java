package a0算法面试题.单例设计模式.单例模式的七种写法;

import a0算法面试题.单例设计模式.单例模式的七种写法.a1.Singleton;

/**
 * @Description 测试类
 * @Author Gao Hang Hang
 * @Date 2020-07-31 23:32
 **/
public class Test {

    public static void main(String[] args) {
        // 假如构造函数为 public 时
        Singleton singleton = new Singleton();
        System.out.println(singleton);

        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

}
