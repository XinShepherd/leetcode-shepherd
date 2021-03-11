package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 227. 基本计算器 II
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 *
 * @author Fuxin
 * @since 2021/3/11
 */
public class Calculate {

    public int calculate(String s) {
        List<Character> operators = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        char[] chars = s.toCharArray();
        int num = 0;
        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                operators.add(c);
                digits.add(num);
                num = 0;
            }
        }
        digits.add(num);
        int size = operators.size();
        for (int i = 0; i < size; ) {
            Character c = operators.get(i);
            if (c == '/' || c == '*') {
                int result;
                if (c == '/') {
                    result = digits.get(i) / digits.get(i + 1);
                } else {
                    result = digits.get(i) * digits.get(i + 1);
                }
                digits.set(i, result);
                digits.remove(i + 1);
                operators.remove(i);
                size--;
            } else {
                i++;
            }
        }
        size = operators.size();
        for (int i = 0; i < size; ) {
            Character c = operators.get(i);
            if (c == '+' || c == '-') {
                int result;
                if (c == '+') {
                    result = digits.get(i) + digits.get(i + 1);
                } else {
                    result = digits.get(i) - digits.get(i + 1);
                }
                digits.set(i, result);
                digits.remove(i + 1);
                operators.remove(i);
                size--;
            } else {
                i++;
            }
        }
        return digits.get(0);
    }

    // 单调栈
    public int calculate2(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        char preSign = '+';
        int num = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);break;
                    case '-':
                        stack.push(-num);break;
                    case '*':
                        stack.push(stack.pop() * num);break;
                    case '/':
                        stack.push(stack.pop() / num);break;
                }
                preSign = c;
                num = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        assertThat(calculate.calculate("3+2*2")).isEqualTo(7);
        assertThat(calculate.calculate(" 3/2 ")).isEqualTo(1);
        assertThat(calculate.calculate(" 3+5 / 2 ")).isEqualTo(5);
        assertThat(calculate.calculate2("3+2*2")).isEqualTo(7);
        assertThat(calculate.calculate2(" 3/2 ")).isEqualTo(1);
        assertThat(calculate.calculate2(" 3+5 / 2 ")).isEqualTo(5);
    }

}
