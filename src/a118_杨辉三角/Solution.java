package a118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/18 10:54
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // First base case; if user requests zero rows, they get zero rows.

        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // 遍历每个三角形元素（除了每行的第一个和最后一个）

            // is equal to the sum of the elements above-and-to-the-left and above-and-to-the-right
            // 等于左上方和右上方元素的总和
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }


    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(6);
        System.out.println(generate);
    }
}
