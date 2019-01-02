package a0算法面试题.单例设计模式;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/02 11:49
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
