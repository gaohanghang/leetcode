package a227_基础计算器2;

public class TestDemo {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        String str1 = new StringBuilder("ja").append("va").toString();
        String str2 = str1.intern();
        System.out.println(str1 == str2);// 结果是false

        String str3 = new StringBuilder("hello").append("world").toString();
        String str4 = str3.intern();
        System.out.println(str3 == str4);// 结果是true
    }
}
