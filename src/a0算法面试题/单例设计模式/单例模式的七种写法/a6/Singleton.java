package a0算法面试题.单例设计模式.单例模式的七种写法.a6;

/**
 * @Description 枚举
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:18
 **/
public enum Singleton {

    INSTANCE;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
