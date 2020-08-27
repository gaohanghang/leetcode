package a0面试题.单例设计模式;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/02 11:38
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance() {
        return instance;
    }
}
