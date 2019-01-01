import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 18:06
 */
public class Solution {

    private static List<Integer> sSorted = new LinkedList<>();

    public static void main(String[] args) {
        addElement(3);
        addElement(2);
        addElement(1);
        addElement(2);
    }

    public static void addElement(int e) {
        int i;
        for (i = 0; i < sSorted.size(); i++) {
            if (e<= sSorted.get(i)){
                break;
            }
        }

        sSorted.add(i, e);
    }
}
