package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 面试题64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author Fuxin
 * @since 2020/6/2
 */
public class SumNums {

    public int sumNums(int n) {
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        SumNums sumNums = new SumNums();
        assertThat(sumNums.sumNums(3)).isEqualTo(6);
        assertThat(sumNums.sumNums(9)).isEqualTo(45);
    }

}
