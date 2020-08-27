package a0面试题.单例设计模式.单例模式的七种写法.a6;

import java.io.*;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 21:56
 **/
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton.INSTANCE.whateverMethod();
        // 简单引用
        Singleton instance0 = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println("instance0===" + instance0.hashCode());
        System.out.println("instance1===" + instance1.hashCode());
        // 反射测试
        Class clazz = Singleton.class;
        Singleton instance2 = (Singleton) Enum.valueOf(clazz, "INSTANCE");
        Singleton instance3 = (Singleton) Enum.valueOf(clazz, "INSTANCE");
        System.out.println("instance2===" + instance2.hashCode());
        System.out.println("instance3===" + instance3.hashCode());
        // 序列化测试
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("test")));
        oos.writeObject(instance0);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("test")));
        Singleton instance4 = (Singleton) ois.readObject();
        ois.close();
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("test")));
        Singleton instance5 = (Singleton) ois1.readObject();
        ois1.close();
        System.out.println("instance4===" + instance4.hashCode());
        System.out.println("instance5===" + instance5.hashCode());
    }

}
