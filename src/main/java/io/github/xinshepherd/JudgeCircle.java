package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 657. 机器人能否返回原点
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 *
 * @author Fuxin
 * @since 2020/8/28
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'L') {
                x--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'U') {
                y++;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        JudgeCircle judgeCircle = new JudgeCircle();
        assertThat(judgeCircle.judgeCircle("UD")).isTrue();
        assertThat(judgeCircle.judgeCircle("UDLR")).isTrue();
        assertThat(judgeCircle.judgeCircle("LL")).isFalse();
        assertThat(judgeCircle.judgeCircle("")).isTrue();
    }

}
