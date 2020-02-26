package io.github.xinshepherd;

import java.util.*;

/**
 * 77. 组合
 * @author Fuxin
 * @since 2020/2/26 9:31
 */
public class CombineNK {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0)
            return Collections.emptyList();

        List<List<Integer>> results = new LinkedList<>();
        Deque<Integer> result = new ArrayDeque<>();
        backtrack(n, 1, k, result, results);
        return results;
    }

    void backtrack(int n, int current, int k, Deque<Integer> result, List<List<Integer>> results) {
        if (result.size() == k) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = current; i < n + 1; i++) {
            result.addLast(i);
            backtrack(n, i + 1, k, result, results);
            result.removeLast();
        }
    }

    public static void main(String[] args) {
        CombineNK combineNK = new CombineNK();
        System.out.println(combineNK.combine(0, 1));
        System.out.println(combineNK.combine(1, 1));
        System.out.println(combineNK.combine(1, 2));
        System.out.println(combineNK.combine(4, 2));
        System.out.println(combineNK.combine(4, 3));
    }

}
