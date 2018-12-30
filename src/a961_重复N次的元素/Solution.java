package a961_重复N次的元素;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2018/12/30 13:17
 */
public class Solution {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3};
        repetedNTimes(A);
    }

    public static int repetedNTimes(int[] A) {
        int N = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) != null) {
                Integer cout = map.get(A[i]);
                map.put(A[i], cout+1);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == N) {
                return A[i];
            }
        }
        return 0;
    }

    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : A) {
            int count = map.getOrDefault(item, 0) + 1;
            map.put(item, count);
            if (count == A.length / 2) {
                return item;
            }
        }
        return 0;
    }
}
