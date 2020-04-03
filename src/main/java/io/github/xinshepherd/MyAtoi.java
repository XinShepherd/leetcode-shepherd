package io.github.xinshepherd;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author Fuxin
 * @since 2020/4/3
 */
public class MyAtoi {

    public int myAtoi(String str) {
        String trim = str.trim();
        if (trim.length() == 0)
            return 0;
        long ans = 0;
        boolean negative = false;
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                negative = c == '-';
            } else {
                if (c >= '0' && c <= '9') {
                    ans = ans * 10 + (c - '0');
                    if (ans > Integer.MAX_VALUE) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (ans > Integer.MAX_VALUE) {
            if (negative)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return negative ? (int) -ans : (int)ans;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("42"));
        System.out.println(myAtoi.myAtoi("   -42"));
        System.out.println(myAtoi.myAtoi("4193 with words"));
        System.out.println(myAtoi.myAtoi("words and 987"));
        System.out.println(myAtoi.myAtoi("-91283472332"));
        System.out.println(myAtoi.myAtoi("-2147483647"));
    }

}
