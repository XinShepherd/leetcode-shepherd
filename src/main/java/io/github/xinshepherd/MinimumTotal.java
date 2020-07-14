package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 120. 三角形最小路径和
// https://leetcode-cn.com/problems/triangle/
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        dynamic(triangle, 0);
        List<Integer> result = triangle.get(triangle.size() - 1);
        int min = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, result.get(i));
        }
        return min;
    }

    void dynamic(List<List<Integer>> triangle, int row) {
        if (row == triangle.size()) {
            return;
        }
        if (row != 0) {
            List<Integer> prev = triangle.get(row - 1);
            List<Integer> currentRow = triangle.get(row);
            int size = currentRow.size();
            for (int i = 0; i < size; i++) {
                Integer current = currentRow.get(i);
                int sum;
                if (i == 0) {
                    sum = current + prev.get(i);
                } else if (i == size - 1) {
                    sum = current + prev.get(i - 1);
                } else {
                    sum = Math.min(current + prev.get(i - 1), current + prev.get(i));
                }
                currentRow.set(i, sum);
            }
        }
        dynamic(triangle, row + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(2);
        List<Integer> secondLine = Arrays.asList(3, 4);
        List<Integer> thirdLine = Arrays.asList(6, 5, 7);
        List<Integer> forthLine = Arrays.asList(4,1,8,3);
        triangle.add(firstLine);
        triangle.add(secondLine);
        triangle.add(thirdLine);
        triangle.add(forthLine);
        MinimumTotal minimumTotal = new MinimumTotal();
        assertThat(minimumTotal.minimumTotal(triangle)).isEqualTo(11);
        assertThat(minimumTotal.minimumTotal(new ArrayList<>())).isEqualTo(0);
    }

}
