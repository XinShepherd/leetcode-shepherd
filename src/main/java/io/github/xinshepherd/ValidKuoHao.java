package io.github.xinshepherd;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author Fuxin
 * @since 2020/8/14
 */
public class ValidKuoHao {

    private final Map<Character, Character> map = new HashMap<>();
    {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidKuoHao validKuoHao = new ValidKuoHao();
        assertThat(validKuoHao.isValid("()")).isTrue();
        assertThat(validKuoHao.isValid("()[]{}")).isTrue();
        assertThat(validKuoHao.isValid("(]")).isFalse();
        assertThat(validKuoHao.isValid("([)]")).isFalse();
        assertThat(validKuoHao.isValid("{[]}")).isTrue();
    }

}
