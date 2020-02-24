package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 * @author Fuxin
 * @since 2020/2/24 14:40
 */
public class Yanghui {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return Collections.emptyList();
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(1));
        if (numRows >= 2) {
            results.add(Arrays.asList(1, 1));
        }
        if (numRows > 2){
            generate(numRows, 3, results);
        }
        return results;
    }

    void generate(int numRows, int num, List<List<Integer>> results) {
        if (num > numRows) return;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        List<Integer> integers = results.get(num - 2);
        for (int i = 1; i < num - 1; i++) {
            int sum = integers.get(i - 1) + integers.get(i);
            result.add(sum);
        }
        result.add(1);
        results.add(result);
        generate(numRows, num + 1, results);
    }

    public static void main(String[] args) {
        Yanghui yanghui = new Yanghui();
        System.out.println(yanghui.generate(5));
    }
}
