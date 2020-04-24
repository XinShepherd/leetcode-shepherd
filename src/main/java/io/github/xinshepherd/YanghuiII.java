package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * @author Fuxin
 * @since 2020/4/24
 */
public class YanghuiII {

    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        ans[0] = 1;
        if (rowIndex > 0) {
            ans[1] = 1;
        }
        int i = 2;
        for (; i < rowIndex + 1; i++) {
            int j = 1;
            int pre = ans[j - 1];
            int cur = ans[j];
            for ( ; j < i; j++) {
                ans[j] = pre + ans[j];
                pre = cur;
                if (j + 1 < i) {
                    cur = ans[j + 1];
                }
            }
            ans[j] = 1;
        }
        return Arrays.asList(ans);
    }

    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex < 0) return Collections.emptyList();
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(1));
        if (rowIndex >= 1) {
            results.add(Arrays.asList(1, 1));
        }
        if (rowIndex > 1){
            generate(rowIndex, 2, results);
        }
        return results.get(rowIndex);
    }

    void generate(int numRows, int num, List<List<Integer>> results) {
        if (num > numRows) return;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        List<Integer> integers = results.get(num - 1);
        for (int i = 1; i < num; i++) {
            int sum = integers.get(i - 1) + integers.get(i);
            result.add(sum);
        }
        result.add(1);
        results.add(result);
        generate(numRows, num + 1, results);
    }

    public static void main(String[] args) {
        YanghuiII yanghuiII = new YanghuiII();
        System.out.println(yanghuiII.getRow(3));
    }


}
