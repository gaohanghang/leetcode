package a0面试题.方法调用超时抛出异常;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-08 14:22
 **/
public class B {

    void c(Object object) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
