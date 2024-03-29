package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 复习：
 * 22. 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author Fuxin
 * @since 2020/4/9
 */
public class CustomGenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, 0, 0, "", res);
        return res;
    }

    private void generate(int n, int left, int right, String ans, List<String> res) {
        if (ans.length() == n * 2) {
            res.add(ans);
            return;
        }
        if (left < n) {
            generate(n, left + 1, right, ans + "(", res);
        }
        if (right < left) {
            generate(n, left, right + 1, ans + ")", res);
        }
    }

    public static void main(String[] args) {
        CustomGenerateParenthesis parenthesis = new CustomGenerateParenthesis();
        Assertions.assertThat(parenthesis.generateParenthesis(3)).isEqualTo(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
    }
}
