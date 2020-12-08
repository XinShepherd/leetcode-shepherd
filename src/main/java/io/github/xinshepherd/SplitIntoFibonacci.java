package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 842. 将数组拆分成斐波那契序列
 *
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 *
 * @author Fuxin
 * @since 2020/12/8
 */
public class SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < S.length(); i++) {
            String s = S.substring(0, i);
            if (isLegal(s)) {
                long l = Long.parseLong(s);
                if (l > Integer.MAX_VALUE)
                    break;
                int num = (int) l;
                ans.add(num);
                boolean finished = backtrack(ans, i, S);
                if (finished)
                    return ans;
                ans.remove(ans.size() - 1);
            } else {
                break;
            }
        }
        return ans;
    }

    boolean backtrack(List<Integer> ans, int i, String S) {
        if (i == S.length() && ans.size() >= 3) {
            return true;
        }
        long sum = 0;
        if (ans.size() >= 2) {
            sum = (long) ans.get(ans.size() - 2) + ans.get(ans.size() - 1);
        }
        for (int j = i + 1; j <= S.length(); j++) {
            String sub = S.substring(i, j);
            if (!isLegal(sub)) {
                return false;
            }
            long l = Long.parseLong(sub);
            if (l > Integer.MAX_VALUE)
                break;
            int num = (int) l;
            if (ans.size() < 2 || sum == num) {
                ans.add(num);
                boolean finished = backtrack(ans, j, S);
                if (finished)
                    return true;
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    boolean isLegal(String s) {
        return !s.startsWith("0") || s.length() == 1;
    }

    public static void main(String[] args) {
        SplitIntoFibonacci splitIntoFibonacci = new SplitIntoFibonacci();
        assertThat(splitIntoFibonacci.splitIntoFibonacci("123456579"))
                .isEqualTo(Arrays.asList(123, 456, 579));
        assertThat(splitIntoFibonacci.splitIntoFibonacci("11235813"))
                .isEqualTo(Arrays.asList(1, 1, 2, 3, 5, 8, 13));
        assertThat(splitIntoFibonacci.splitIntoFibonacci("112358130"))
                .isEqualTo(Collections.emptyList());
        assertThat(splitIntoFibonacci.splitIntoFibonacci("0123"))
                .isEqualTo(Collections.emptyList());

    }
}
