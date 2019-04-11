package a692_前k个高频单词;

import java.util.*;

public class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // 使用堆排序 小根堆 k个元素 出现次数为 1 second 3 4
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2)
        );

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add(heap.poll());
        // 将list翻转 4 3 second 1
        Collections.reverse(ans);
        return ans;
    }
}
