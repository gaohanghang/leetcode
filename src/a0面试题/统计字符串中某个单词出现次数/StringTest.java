package a0面试题.统计字符串中某个单词出现次数;

/**
 * 思路：查询字符串是否包含单词，如果包含就count + 1 并截取之后在子串在判断是否包含单词
 */
public class StringTest {

    public static void main(String[] args){
        int count = countWord("HelloWord   HelloABCHe  llo","Hello");
        System.out.println("count:" + count);
    }

    public static int countWord(String s,String word) {
        // 定义count变量
        int count = 0;
        // 子串
        String substr;
        // 下标
        int index;
        while (s.contains(word)) {
            count++;
            index = s.indexOf(word);
            substr = s.substring(index + word.length());
            s = substr;
            System.out.println("子串：" + s);
        }
        return count;
    }

}
