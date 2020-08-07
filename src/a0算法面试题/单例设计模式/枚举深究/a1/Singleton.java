package a0算法面试题.单例设计模式.枚举深究.a1;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-06 14:01
 **/
public enum  Singleton {

    INSTANCE;
    private Singleton() {
        System.out.println("Here");
    }

}
