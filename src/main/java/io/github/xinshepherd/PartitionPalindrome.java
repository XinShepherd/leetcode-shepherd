package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

// 131. 分割回文串 https://leetcode-cn.com/problems/palindrome-partitioning/
public class PartitionPalindrome {

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return Collections.emptyList();
        List<List<String>> results = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        partition(s, result, results);
        return results;
    }

    void partition(String s, LinkedList<String> result, List<List<String>> results) {
        if (s == null || s.length() == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (!isPalindrome(sub))
                continue;
            result.addLast(sub);
            partition(s.substring(i + 1), result, results);
            result.removeLast();
        }
    }

    boolean isPalindrome(String str) {
        int length = str.length();
        if (length == 1)
            return true;
        for (int i = 0; i < (length + 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionPalindrome partitionPalindrome = new PartitionPalindrome();
        Assertions.assertThat(partitionPalindrome.partition("aab")).isEqualTo(Arrays.asList(
                Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b")
        ));
        Assertions.assertThat(partitionPalindrome.partition("aabbcdd")).isEqualTo(Arrays.asList(
                Arrays.asList("a", "a", "b", "b", "c", "d", "d"),
                Arrays.asList("a", "a", "b", "b", "c", "dd"),
                Arrays.asList("a", "a", "bb", "c", "d", "d"),
                Arrays.asList("a", "a", "bb", "c", "dd"),
                Arrays.asList("aa", "b", "b", "c", "d", "d"),
                Arrays.asList("aa", "b", "b", "c", "dd"),
                Arrays.asList("aa", "bb", "c", "d", "d"),
                Arrays.asList("aa", "bb", "c", "dd")
        ));
        Assertions.assertThat(partitionPalindrome.partition("")).isEqualTo(Arrays.asList());
        Assertions.assertThat(partitionPalindrome.partition("a")).isEqualTo(Arrays.asList(
                Arrays.asList("a")
        ));
    }
}
