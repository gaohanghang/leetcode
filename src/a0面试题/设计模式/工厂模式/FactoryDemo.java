package a0面试题.设计模式.工厂模式;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-26 22:32
 **/
public class FactoryDemo {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone huawei = factory.createPhone("HuaWei");
        Phone iphone = factory.createPhone("Apple");
        System.out.println(huawei.brand());
        System.out.println(iphone.brand());
    }

}
