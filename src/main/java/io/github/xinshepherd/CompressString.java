package io.github.xinshepherd;

/**
 * 面试题 01.06. 字符串压缩
 *
 * @author Fuxin
 * @since 2020/3/16 8:57
 */
public class CompressString {

    public String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        char current = S.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < S.length(); i++) {
            if (current == S.charAt(i)) {
                count++;
            } else {
                sb.append(current).append(count);
                current = S.charAt(i);
                count = 1;
            }
        }
        sb.append(current).append(count);
        if (sb.length() < S.length()) {
            return sb.toString();
        }
        return S;
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        System.out.println(compressString.compressString(""));
        System.out.println(compressString.compressString("a"));
        System.out.println(compressString.compressString("abc"));
        System.out.println(compressString.compressString("aaa"));
        System.out.println(compressString.compressString("aabcccccaaa"));
        System.out.println(compressString.compressString("abbccd"));
    }

}
