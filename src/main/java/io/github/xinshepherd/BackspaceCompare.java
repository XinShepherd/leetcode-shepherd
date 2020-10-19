package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 844. 比较含退格的字符串
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * @author Fuxin
 * @since 2020/10/19
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        int si = S.length() - 1;
        int ti = T.length() - 1;
        while (si >= 0 && ti >= 0) {
            si = getIndex(S, si);
            ti = getIndex(T, ti);
            if (si >= 0 && ti >= 0) {
                if (S.charAt(si) != T.charAt(ti)) {
                    return false;
                }
                si--;
                ti--;
            }
        }
        si = getIndex(S, si);
        ti = getIndex(T, ti);
        return ti == si;
    }

    int getIndex(String str, int index) {
        int count = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        BackspaceCompare compare = new BackspaceCompare();
        assertThat(compare.backspaceCompare("ab#c", "ad#c")).isTrue();
        assertThat(compare.backspaceCompare("ab##", "c#d#")).isTrue();
        assertThat(compare.backspaceCompare("a##c", "#a#c")).isTrue();
        assertThat(compare.backspaceCompare("a#c", "b")).isFalse();
        assertThat(compare.backspaceCompare("bxj##tw", "bxj###tw")).isFalse();
        assertThat(compare.backspaceCompare("nzp#o#g", "b#nzp#o#g")).isTrue();
    }

}
