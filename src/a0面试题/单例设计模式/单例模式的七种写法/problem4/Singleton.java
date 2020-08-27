package a0面试题.单例设计模式.单例模式的七种写法.problem4;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 13:38
 **/
public class Singleton {

    public static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static void main(String[] args) {
        Singleton.singleton = null;
        System.out.println(Singleton.singleton);
    }

}
