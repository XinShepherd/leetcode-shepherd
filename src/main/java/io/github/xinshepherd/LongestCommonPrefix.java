package io.github.xinshepherd;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int i = 0;
        outer:
        while (true) {
            int c = Integer.MIN_VALUE;
            for (String str : strs) {
                if (i >= str.length()) {
                    break outer;
                }
                char current = str.charAt(i);
                if (c == Integer.MIN_VALUE) {
                    c = current;
                } else if (c != current) {
                    break outer;
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
