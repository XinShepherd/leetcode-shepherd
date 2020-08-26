package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author Fuxin
 * @since 2020/8/26
 */
public class LetterCombinations {

    private static Map<Character, String> mapping = new HashMap<>();

    static {
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
    }

    private final List<String> results = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return Collections.emptyList();
        dfs(digits, 0, new StringBuilder());
        return results;
    }

    void dfs(String digits, int cur, StringBuilder result) {
        if (result.length() == digits.length()) {
            results.add(result.toString());
            return;
        }
        char c = digits.charAt(cur);
        String value = mapping.get(c);
        for (int i = 0; i < value.length(); i++) {
            dfs(digits, cur + 1, result.append(value.charAt(i)));
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        assertThat(letterCombinations.letterCombinations("23")).hasSameElementsAs(
                Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        );
    }

}
