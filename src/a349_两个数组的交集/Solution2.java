package a349_两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 使用stream方式
 * @author: Gao Hang Hang
 * @date 2019/03/13 17:14
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(Arrays.stream(nums2).boxed().toArray(Integer[]::new)));
        s1.retainAll(s2);  //求交集
        return s1.stream().mapToInt(Integer::valueOf).toArray();  //set转int[]
    }
}
