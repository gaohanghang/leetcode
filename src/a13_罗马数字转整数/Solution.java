package a13_罗马数字转整数;

import java.util.HashMap;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/31 17:01
 */
public class Solution {

    public static void main(String[] args) {
        romanToInt("MCMXCIV");
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( i != s.length() -1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
