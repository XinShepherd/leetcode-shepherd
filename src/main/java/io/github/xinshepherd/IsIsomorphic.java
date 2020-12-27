package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 205. 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author Fuxin
 * @since 2020/12/27
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) {
            return false;
        }
        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            Character sChar = sMap.get(c);
            Character tChar = tMap.get(tChars[i]);
            if (sChar != null) {
                if (sChar != tChars[i]) {
                    return false;
                }
            } else {
                sMap.put(c, tChars[i]);
            }
            if (tChar != null) {
                if (c != tChar)
                    return false;
            } else {
                tMap.put(tChars[i], c);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int len = 128;
        char[] sMap = new char[len];
        char[] tMap = new char[len];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) {
            return false;
        }
        for (int i = 0; i < sChars.length; i++) {
            char x = sChars[i], y = tChars[i];
            if ((sMap[x] != 0 && sMap[x] != y) || (tMap[y] != 0 && tMap[y] != x)) {
                return false;
            }
            sMap[x] = y;
            tMap[y] = x;
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        assertThat(isIsomorphic.isIsomorphic("egg", "add")).isTrue();
        assertThat(isIsomorphic.isIsomorphic("foo", "bar")).isFalse();
        assertThat(isIsomorphic.isIsomorphic("paper", "title")).isTrue();
        assertThat(isIsomorphic.isIsomorphic("ab", "aa")).isFalse();
        assertThat(isIsomorphic.isIsomorphic2("egg", "add")).isTrue();
        assertThat(isIsomorphic.isIsomorphic2("foo", "bar")).isFalse();
        assertThat(isIsomorphic.isIsomorphic2("paper", "title")).isTrue();
        assertThat(isIsomorphic.isIsomorphic2("ab", "aa")).isFalse();
    }

}
