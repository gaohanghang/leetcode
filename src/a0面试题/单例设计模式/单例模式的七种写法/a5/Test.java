package a0面试题.单例设计模式.单例模式的七种写法.a5;

import a0面试题.单例设计模式.单例模式的七种写法.a1.Singleton;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-13 22:26
 **/
public class Test {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

}
