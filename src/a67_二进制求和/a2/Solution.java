package a67_二进制求和.a2;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-12 01:27
 **/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() -1, j = b.length() -1; i >= 0 || j>= 0 ; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            // 判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            // sum % 2 是在做二进制取模运算，比如sum=2, 这时候sum%2=0, 这时候将sum%2=0放入结果集
            ans.append(sum % 2);
            // 这里是计算进位，比如sum=2, ca = 1, ca表示进位的意思，满2进1
            ca = sum / 2;
        }
        // 这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
