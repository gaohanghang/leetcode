package a119_杨辉三角2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/18 11:20
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);

        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i -1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow(3);
        System.out.println(row);
    }

}
