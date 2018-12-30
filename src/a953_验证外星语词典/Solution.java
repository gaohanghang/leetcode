package a953_验证外星语词典;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/30 13:53
 */
public class Solution {
    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        isAlienSorted(words, order);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        // 记录每一个单词在外星的位置权重信息
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        return true;

    }
}
