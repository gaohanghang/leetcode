package a0算法面试题.单例设计模式.破坏单例模式和防止破坏单例模式.a3序列化破坏单例模式;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-07 17:51
 **/
public class Test {

    public static void main(String[] args) {

        Singleton s1 = null;
        //通过类本身获得实例对象
        Singleton s2 = Singleton.getInstance();
        FileOutputStream fos = null;

        try {
            // 序列化到文件中
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            // 从文件中反序列化为对象
            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Singleton) ois.readObject();
            ois.close();
            // 对比结果,这里输出的结果为false
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
