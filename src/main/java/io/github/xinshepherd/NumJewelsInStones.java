package io.github.xinshepherd;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 771. 宝石与石头
 *
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author Fuxin
 * @since 2020/10/2
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumJewelsInStones jewels = new NumJewelsInStones();
        assertThat(jewels.numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
        assertThat(jewels.numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }
}
