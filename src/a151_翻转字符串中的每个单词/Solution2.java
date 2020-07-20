package a151_翻转字符串中的每个单词;

/**
 * 先反转字符串再反转每个单词
 * - 先翻转整个字符串
 * - 再翻转每个单词
 * <p>
 * 复杂度分析
 * 时间复杂度：O(N) 遍历字符串
 * 空间复杂度：O(N)
 *
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-18 02:17
 **/
public class Solution2 {

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') { // 字符串末尾不为空格就添加，否则就不添加，以此去除字符串间多余的空白字符
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    /**
     * 翻转字符串
     *
     * @param sb
     * @param left
     * @param right
     */
    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            // 左侧字符和右侧互换
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    /**
     * 翻转每个单词
     *
     * @param sb
     */
    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

    public String reverseWords(String s) {
        // 去除空格
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

}
