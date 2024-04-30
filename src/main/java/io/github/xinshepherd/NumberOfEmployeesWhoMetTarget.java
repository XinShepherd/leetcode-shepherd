package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/number-of-employees-who-met-the-target/description/">2798. 满足目标工作时长的员工数目</a>
 * @author Fuxin
 */
public class NumberOfEmployeesWhoMetTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;
        for (int hour : hours) {
            if (hour >= target) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfEmployeesWhoMetTarget solution = new NumberOfEmployeesWhoMetTarget();
        Assertions.assertThat(solution.numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 2)).isEqualTo(3);
        Assertions.assertThat(solution.numberOfEmployeesWhoMetTarget(new int[]{5,1,4,2,2}, 6)).isEqualTo(0);
    }

}
