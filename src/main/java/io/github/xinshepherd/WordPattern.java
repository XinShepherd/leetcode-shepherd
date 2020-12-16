package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 290. 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/
 *
 * @author Fuxin
 * @since 2020/12/16
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            String string = strings[i];
            String str = map.get(c);
            Character character = strMap.get(string);
            if (str == null) {
                map.put(c, string);
            } else if (!str.equals(string)) {
                return false;
            }
            if (character == null) {
                strMap.put(string, c);
            } else if (!character.equals(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        assertThat(wordPattern.wordPattern("abba", "dog cat cat dog")).isTrue();
        assertThat(wordPattern.wordPattern("abba", "dog dog dog dog")).isFalse();
        assertThat(wordPattern.wordPattern("aaaa", "dog cat cat dog")).isFalse();
        assertThat(wordPattern.wordPattern("abba", "dog cat cat fish")).isFalse();
        assertThat(wordPattern.wordPattern("abc", "dog cat dog")).isFalse();
    }

}
