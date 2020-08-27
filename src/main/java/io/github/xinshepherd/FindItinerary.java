package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 332. 重新安排行程
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 *
 * 标签：图，深度优先，优先队列
 *
 * @author Fuxin
 * @since 2020/8/27
 */
public class FindItinerary {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String src) {
        while (map.containsKey(src) && map.get(src).size() > 0) {
            String dst = map.get(src).poll();
            dfs(dst);
        }
        itinerary.add(src);
    }

    public static void main(String[] args) {
        FindItinerary findItinerary = new FindItinerary();
        List<String> result = findItinerary.findItinerary(Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        ));
        assertThat(result).isEqualTo(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"));
    }

}
