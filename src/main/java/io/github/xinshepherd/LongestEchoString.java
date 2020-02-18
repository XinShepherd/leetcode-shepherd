package io.github.xinshepherd;

public class LongestEchoString {

    public String longestPalindrome(String s) {
        return echoStr(s);
    }
    public String echoStr(String str) {
        int length = str.length();
        if(length == 0 || length == 1) return str;
        String result = "";
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                String sub = str.substring(i, j);
                if (sub.length() > result.length()) {
                    if (isEchoStr(sub)) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
    boolean isEchoStr(String str) {
        int length = str.length();
        for (int i = 0; i < (length + 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LongestEchoString solution = new LongestEchoString();
        System.out.println(solution.echoStr("babaad"));
        System.out.println(solution.echoStr("cbbd"));
        System.out.println(solution.echoStr("bb"));
    }
}
