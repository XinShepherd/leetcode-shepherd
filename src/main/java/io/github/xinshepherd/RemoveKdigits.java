package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 *
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ans = new StringBuilder();
        boolean zero = true;
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (zero && c == '0') {
                continue;
            }
            zero = false;
            ans.append(c);
        }
        return zero ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        Assertions.assertThat(removeKdigits.removeKdigits("1432219", 3)).isEqualTo("1219");
        Assertions.assertThat(removeKdigits.removeKdigits("10200", 1)).isEqualTo("200");
        Assertions.assertThat(removeKdigits.removeKdigits("10", 2)).isEqualTo("0");
    }

}
