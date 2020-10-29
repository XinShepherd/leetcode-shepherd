package io.github.xinshepherd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1207. 独一无二的出现次数
 *
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 *
 * @author Fuxin
 * @since 2020/10/28
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (set.contains(value))
                return false;
            set.add(value);
        }
        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        int[] counters = new int[2001];
        for (int i : arr) {
            counters[i + 1000]++;
        }
        Set<Integer> set = new HashSet<>(arr.length);
        for (int counter : counters) {
            if (counter > 0) {
                if (set.contains(counter))
                    return false;
                set.add(counter);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueOccurrences uniqueOccurrences = new UniqueOccurrences();
        assertThat(uniqueOccurrences.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})).isTrue();
        assertThat(uniqueOccurrences.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})).isTrue();
        assertThat(uniqueOccurrences.uniqueOccurrences(new int[]{1, 2})).isFalse();
        assertThat(uniqueOccurrences.uniqueOccurrences2(new int[]{1, 2, 2, 1, 1, 3})).isTrue();
        assertThat(uniqueOccurrences.uniqueOccurrences2(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})).isTrue();
        assertThat(uniqueOccurrences.uniqueOccurrences2(new int[]{1, 2})).isFalse();
    }

}
