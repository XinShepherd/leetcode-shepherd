package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        generateParenthesis(list, "", 0, 0, n);
        return list;
    }


    private void generateParenthesis(ArrayList<String> list, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            list.add(cur);
            return;
        }
        if (open < max) {
            generateParenthesis(list, cur + '(', open + 1, close, max);
        }
        if (open > close) {
            generateParenthesis(list, cur + ')', open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis parenthesis = new GenerateParenthesis();
        Assertions.assertThat(parenthesis.generateParenthesis(3)).isEqualTo(Arrays.asList(
                "((()))","(()())","(())()","()(())","()()()"
        ));
        Assertions.assertThat(parenthesis.generateParenthesis(1)).isEqualTo(Arrays.asList(
                "()"
        ));
    }
}
