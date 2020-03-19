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

    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLen(s, i, i);
            int len2 = getLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    int getLen(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestEchoString solution = new LongestEchoString();
        System.out.println(solution.longestPalindrome2("babaad"));
        System.out.println(solution.longestPalindrome2("cbbd"));
        System.out.println(solution.longestPalindrome2("bb"));
        System.out.println(solution.longestPalindrome2("ccc"));
    }
}
