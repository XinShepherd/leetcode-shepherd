package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 131. 分割回文串
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
        List<List<String>> aab = partitionPalindrome.partition("aab");
        System.out.println(aab);

        List<List<String>> aabbcdd = partitionPalindrome.partition("aabbcdd");
        System.out.println(aabbcdd);

        // 其他情况
        System.out.println(partitionPalindrome.partition(""));
        System.out.println(partitionPalindrome.partition("a"));
    }
}
