package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 914. 卡牌分组
 *
 * @author Fuxin
 * @since 2020/3/27
 */
public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            Integer v = map.getOrDefault(num, 0);
            map.put(num, ++v);
        }
        int minCount = deck.length;

        Set<Integer> values = new HashSet<>(map.values());
        for (Integer v : values) {
            minCount = Math.min(minCount, v);
        }
        if (minCount < 2) return false;
        int sqrt = (int) Math.sqrt(minCount);
        for (int i = 2; i < sqrt + 2; i++) {
            if (minCount % i == 0) {
                boolean group = isGroup(values, i) || isGroup(values, minCount / i);
                if (group) return true;
            }

        }

        return isGroup(values, minCount);
    }

    boolean isGroup(Set<Integer> values, int i) {
        if (i < 2) return false;
        for (Integer v : values) {
            if (v % i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HasGroupsSizeX groupsSizeX = new HasGroupsSizeX();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})).isTrue();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})).isFalse();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1})).isFalse();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1, 1})).isTrue();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})).isTrue();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2})).isTrue();
        Assertions.assertThat(groupsSizeX.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2})).isTrue();
    }

}
