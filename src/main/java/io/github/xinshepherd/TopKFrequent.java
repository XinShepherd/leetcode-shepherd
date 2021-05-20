package io.github.xinshepherd;

import java.util.*;

/**
 * 692. 前K个高频单词
 *
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 *
 * @author Fuxin
 * @since 2021/5/20
 */
public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.getOrDefault(word, 0);
            map.put(word, ++count);
        }
        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
            int compare = a.getValue().compareTo(b.getValue());
            if (compare == 0)
                return b.getKey().compareTo(a.getKey());
            return compare;
        };
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, comparator);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            ret.add(queue.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}
