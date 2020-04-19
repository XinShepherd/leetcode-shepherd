package io.github.xinshepherd;

/**
 * 28. 实现 strStr()
 *
 * @author Fuxin
 * @since 2020/4/19
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            boolean matched = true;
            if ((haystack.length() - i) < needle.length())
                return -1;
            for (int j = 0, k = i; j < needle.length() && k < haystack.length();) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    matched = false;
                    break;
                }
                k++;
                j++;
            }
            if (matched)
                return i;
        }
        return -1;
    }

    // 直接采用 substring
    public int subString(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        int len = haystack.length();
        for (int i = 0; i < len; i++) {
            if ((len - i) < needle.length()) {
                return -1;
            }
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(String haystack, String needle) {
        char[] target = needle.toCharArray();
        int targetCount = target.length;
        if (targetCount == 0)
            return 0;
        char[] source = haystack.toCharArray();
        int sourceCount = source.length;
        int max = sourceCount - targetCount;
        if (max < 0)
            return -1;
        char first = target[0];

        for (int i = 0; i <= max; i++) {
            while (i <= max && source[i] != first) {
                i++;
            }
            if (i <= max) {
                int j = i + 1;
                int end = i + targetCount;
                for (int k = 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        System.out.println(str.indexOf("hello", "ll"));
    }

}
