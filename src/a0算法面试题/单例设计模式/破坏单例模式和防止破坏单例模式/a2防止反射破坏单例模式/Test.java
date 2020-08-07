package a0算法面试题.单例设计模式.破坏单例模式和防止破坏单例模式.a2防止反射破坏单例模式;

import java.lang.reflect.Constructor;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-07 17:12
 **/
public class Test {

    public static void main(String[] args) {
        try {
            // 很无聊的情况下，进行破坏
            Class<?> clazz = Singleton.class;
            // 通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor();
            // 因为要访问私有的构造方法，这里要设为true，相当于让你有权限去操作
            c.setAccessible(true);
            // 暴力初始化
            Object o1 = c.newInstance();
            // 调用了两次构造方法，相当于 new 了两次
            Object o2 = c.newInstance();
            // 这里输出结果为false
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
