package a0算法面试题.单例设计模式.单例模式的七种写法.a6;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 21:56
 **/
public class Test {

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        System.out.println(instance.getValue());
        instance.setValue(2);
        System.out.println(instance.getValue());
    }

}
