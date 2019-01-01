package a67_二进制求和;

import java.util.LinkedList;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 16:02
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));;
    }

    public static String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;
        while (i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}
