package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效括号
 */
public class ValidParentheses {

    private final Map<Character, Character> mapping = new HashMap<>();

    {
        mapping.put('(', ')');
        mapping.put('{', '}');
        mapping.put('[', ']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (mapping.containsKey(c)) {
                stack.push(c);
            } else {
                Character pop = stack.isEmpty() ? '#' : stack.pop();
                if (!c.equals(mapping.get(pop))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        Assertions.assertThat(validParentheses.isValid("(")).isEqualTo(false);
        Assertions.assertThat(validParentheses.isValid("}")).isEqualTo(false);
        Assertions.assertThat(validParentheses.isValid("()[]{}")).isEqualTo(true);
        Assertions.assertThat(validParentheses.isValid("(]")).isEqualTo(false);
        Assertions.assertThat(validParentheses.isValid("([)]")).isEqualTo(false);
        Assertions.assertThat(validParentheses.isValid("{[]}")).isEqualTo(true);
    }

}
