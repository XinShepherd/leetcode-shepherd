package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190 反转每对括号间的子串
 *
 * @author Fuxin
 * @since 2021/5/26
 */
public class ReverseParentheses {

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseParentheses parentheses = new ReverseParentheses();
        Assertions.assertThat(parentheses.reverseParentheses("(abcd)")).isEqualTo("dcba");
        Assertions.assertThat(parentheses.reverseParentheses("yfgnxf")).isEqualTo("yfgnxf");
        Assertions.assertThat(parentheses.reverseParentheses("(u(love)i)")).isEqualTo("iloveu");
        Assertions.assertThat(parentheses.reverseParentheses("a(bcdefghijkl(mno)p)q")).isEqualTo("apmnolkjihgfedcbq");
        Assertions.assertThat(parentheses.reverseParentheses("ata()usw((((a))))")).isEqualTo("atauswa");
    }

}
