package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 649. Dota2 参议院
 *
 * https://leetcode-cn.com/problems/dota2-senate/
 *
 */
public class PredictPartyVictory {

    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        Deque<Character> queue = new LinkedList<>();
        for (char c : chars) {
            queue.add(c);
        }
        queue.add('|'); // 哨兵
        char current = chars[0];
        int count = 0;
        boolean same = true;
        while (!queue.isEmpty()) {
            Character c = queue.pollFirst();
            if (c == '|') {
                if (same)
                    break;
                queue.add(c);
                same = true;
                continue;
            }
            if (c == current) {
                count++;
            } else {
                same = false;
                if (count > 0) {
                    count--;
                    queue.add(current);
                } else {
                    current = c;
                    count = 1;
                }
            }
        }
        return current == 'D' ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        PredictPartyVictory predictPartyVictory = new PredictPartyVictory();
        assertThat(predictPartyVictory.predictPartyVictory("RD")).isEqualTo("Radiant");
        assertThat(predictPartyVictory.predictPartyVictory("RDD")).isEqualTo("Dire");
        assertThat(predictPartyVictory.predictPartyVictory("RDDDRR")).isEqualTo("Dire");
        assertThat(predictPartyVictory.predictPartyVictory("R")).isEqualTo("Radiant");
        assertThat(predictPartyVictory.predictPartyVictory("DDRRRDRR")).isEqualTo("Radiant");
        assertThat(predictPartyVictory.predictPartyVictory("DDRRR")).isEqualTo("Dire");
    }

}
