package io.github.xinshepherd;

import java.util.*;
public class RomanToInt {
    private final Map<Character, Integer> mapping = new HashMap<>();
    {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            int next = i + 1;
            if (next >= length) {
                sum += mapping.get(c);
            } else {
                char second = chars[next];
                int number = 0;
                if (c == 'I') {
                    if (second == 'V') {
                        number = 4;
                    }
                    if (second == 'X') {
                        number = 9;
                    }
                }
                if (c == 'X') {
                    if (second == 'L') {
                        number = 40;
                    }
                    if (second == 'C') {
                        number = 90;
                    }
                }
                if (c == 'C') {
                    if (second == 'D') {
                        number = 400;
                    }
                    if (second == 'M') {
                        number = 900;
                    }
                }
                if (number != 0) {
                    sum += number;
                    i++;
                } else {
                    sum += mapping.get(c);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInt solution = new RomanToInt();
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("IX"));
    }
}
