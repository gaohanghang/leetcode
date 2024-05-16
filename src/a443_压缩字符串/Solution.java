package a443_压缩字符串;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-16 23:48
 **/
public class Solution {
    // 数组大小范围：1 <= chars.length <= 1000
    public int compress(char[] chars) {
        int left = 0;
        int size = 0;

        // 由于最后一个字符也需要判断，所以将右指针终点放到数组之外一格
        // right <= chars.length 中的等于是为了代码里的 right - left 的计算
        for (int right = 0; right <= chars.length ; right++) {
            // 当遍历完成，或右指针元素不等与左指针元素时，更新数组
            if (right == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left]; // 更新字符
                if (right - left > 1) {  // 更新计数，当个数大于 1 时才更新
                    // 假设一个字符出现的个数是23，则转化为‘2’，‘3’两个字符
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int compress = new Solution().compress(chars);
        System.out.println(compress);
    }
}
