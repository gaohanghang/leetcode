package a0面试题.String;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-12-23 12:21
 **/
public class Test {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        //System.out.println(test2.getA() == test1.getA());

        //test();

        String a4 = new String("abc");

        System.out.println(a4 == test1.getA());


        System.out.println(test1.a5 == test1.getA());
    }

    public static void test() {
        Test1 test1 = new Test1();

        String a3 = "abc";
        System.out.println(a3 == test1.getA());
    }
}
