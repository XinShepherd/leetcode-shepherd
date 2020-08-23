package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 679. 24 点游戏
 * https://leetcode-cn.com/problems/24-game/
 *
 * @author Fuxin
 * @since 2020/8/22
 */
public class JudgePoint24 {

    private static final int TARGET = 24;
    private static final double ZERO = 1e-6;
    private static final int MULTI =0, ADD = 1,  SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            return Math.abs(list.get(0) - TARGET) <= ZERO;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == MULTI) {
                            list2.add(list.get(i) * list.get(j));
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        }
                        if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        }
                        if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) <= ZERO) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JudgePoint24 judgePoint24 = new JudgePoint24();
        assertThat(judgePoint24.judgePoint24(new int[]{4, 1, 8, 7})).isTrue();
        assertThat(judgePoint24.judgePoint24(new int[]{1, 2, 1, 2})).isFalse();
    }

}
