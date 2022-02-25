package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.AbstractMap;

/**
 * 537. 复数乘法
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 * <p>
 * (A + Bi) * (C + Di) = A*C + (A*D + B*C)i - B*D
 *
 * @author Fuxin
 */
public class ComplexNumberMultiply {

    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+");
        int A = Integer.parseInt(split1[0]);
        int B = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        String[] split2 = num2.split("\\+");
        int C = Integer.parseInt(split2[0]);
        int D = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));

        int i = A * C - B * D;
        int x = A * D + B * C;
        return String.valueOf(i) + '+' + x + 'i';
    }

    public String complexNumberMultiply2(String num1, String num2) {
        int plusIndex = num1.indexOf('+');
        int A = Integer.parseInt(num1.substring(0, plusIndex));
        int B = Integer.parseInt(num1.substring(plusIndex + 1, num1.length() - 1));
        int plusIndex2 = num2.indexOf('+');
        int C = Integer.parseInt(num2.substring(0, plusIndex2));
        int D = Integer.parseInt(num2.substring(plusIndex2 + 1, num2.length() - 1));

        int i = A * C - B * D;
        int x = A * D + B * C;
        return String.valueOf(i) + '+' + x + 'i';
    }

    private AbstractMap.SimpleEntry<Integer, Integer> parseInt(String num) {
        String[] split = num.split("\\+");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
        return new AbstractMap.SimpleEntry<>(a, b);
    }

    public static void main(String[] args) {
        ComplexNumberMultiply complexNumberMultiply = new ComplexNumberMultiply();
        Assertions.assertThat(complexNumberMultiply.complexNumberMultiply("1+1i", "1+1i")).isEqualTo("0+2i");
        Assertions.assertThat(complexNumberMultiply.complexNumberMultiply("1+-1i", "1+-1i")).isEqualTo("0+-2i");
        Assertions.assertThat(complexNumberMultiply.complexNumberMultiply2("1+1i", "1+1i")).isEqualTo("0+2i");
        Assertions.assertThat(complexNumberMultiply.complexNumberMultiply2("1+-1i", "1+-1i")).isEqualTo("0+-2i");
    }

}
