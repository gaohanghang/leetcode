package a349_两个数组的交集;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/14 09:13
 */
public class strSplit {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");
        list2.add("g");
        list2.add("c");
        list2.add("b");
        list2.add("a");
        list1.retainAll(list2);
        System.out.print(list1);
    }
}
