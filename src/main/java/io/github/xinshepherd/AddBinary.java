package io.github.xinshepherd;

/**
 * 67. 二进制求和
 *
 * @author Fuxin
 * @since 2020/4/12
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder sb = new StringBuilder();
        int step = 0;
        int i = a.length() - 1;
        for (int j = b.length() - 1; j >= 0; i--, j--) {
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(j) - '0';
            int sum = num1 + num2 + step;
            sb.append(sum % 2);
            step = sum / 2;
        }
        for (; i >= 0; i--) {
            if (step > 0) {
                int sum = a.charAt(i) - '0' + step;
                sb.append(sum % 2);
                step = sum / 2;
            } else {
                sb.append(a.charAt(i));
            }
        }
        if (step > 0) {
            sb.append(step);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary binary = new AddBinary();
        System.out.println(binary.addBinary("11", "1"));
    }

}
