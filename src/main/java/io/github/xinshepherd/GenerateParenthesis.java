package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

// 22. 括号生成
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
        System.out.println(parenthesis.generateParenthesis(3));
        System.out.println(parenthesis.generateParenthesis(4));
    }
}
