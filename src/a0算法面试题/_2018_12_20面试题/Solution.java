package a0算法面试题._2018_12_20面试题;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 统计一个文件里面的所有字符，输出前五个出现最多的字符以及他们的出现次数
 * 【思路】：首先将字符串拆分为字符数组，然后转存到HashMap集合中，该集合的key为字符串中出现的字符，value对应该字符出现的次数。最后只需要在HashMap集合中找到Value值最大的key即可。实现代码如下（PS：输出形式若有变化，自己修改哈）
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/11 22:14
 */
public class Solution {

    public static void main(String[] args) {
        String str = "AAbbcccaaaaa";
        char[] chars = str.toCharArray(); // 把字符串转为字符数组toCharArray
        Map<Character, Integer> map = MapFunction(chars);
        Character character = FindMapMaxValue(map);
        System.out.println(character);
    }

    /**
     * MapFunction:实现将字符数组转存到Map中， 其中，Map中的key为出现的字符，value对应该字符出现的次数
     *
     * @param chars
     * @return
     */
    private static Map<Character, Integer> MapFunction(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        if (chars == null || chars.length ==0) return map;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) != null) {
                // 若大于0说明存在相同字符，则Value值在原来的基础上加1
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        return map;
    }

    public static Character FindMapMaxValue(Map<Character, Integer> map) {
        Set<Character> keys = map.keySet();// 获得所有key值
        Iterator<Character> iterator = keys.iterator();// 实例化Iterator
        Character maxKey = iterator.next();
        int maxValue = map.get(maxKey);

        while (iterator.hasNext()) {
            Character temp = iterator.next();
            if (maxValue < map.get(temp)) {
                maxKey = temp;
                maxValue = map.get(temp);
            }
        }
        return maxKey;
    }
}
