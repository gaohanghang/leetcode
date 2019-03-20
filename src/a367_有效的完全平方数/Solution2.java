package a367_有效的完全平方数;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/20 12:36
 */
public class Solution2 {
    public boolean isPerfectSquare(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r * r == x;
    }

    public static void main(String[] args) {
        new Solution2().isPerfectSquare(81);
    }
}
