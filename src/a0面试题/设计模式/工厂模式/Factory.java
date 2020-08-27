package a0面试题.设计模式.工厂模式;

/**
 * @Description 工厂类
 * @Author Gao Hang Hang
 * @Date 2020-08-26 22:30
 **/
public class Factory {

    public Phone createPhone(String phoneName) {
        if ("HuaWei".equals(phoneName)) {
            return new HuaWei();
        } else if ("Apple".equals(phoneName)) {
            return new IPhone();
        } else {
            return null;
        }
    }

}
