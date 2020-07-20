package a151_翻转字符串中的每个单词;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-07-18 18:10
 **/
public class Test {

    public static void main(String[] args) {
        // 测试用例
        String str = "the sky is blue"; // 正常情况
        String str2 = " the sky is blue ";
        String str3 = "     "; // 全是空格的情况

        // 测试
        Solution solution = new Solution();
        String result1 = solution.reverseWords(str);

        Solution2 solution2 = new Solution2();
        String result2 = solution2.reverseWords(str);

        Solution3 solution3 = new Solution3();
        String result12 = solution3.reverseWords(str);
    }

}
