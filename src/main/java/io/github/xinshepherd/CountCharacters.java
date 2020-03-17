package io.github.xinshepherd;

import java.util.Arrays;

/**
 * 1160. 拼写单词
 *
 * @author Fuxin
 * @since 2020/3/17 9:47
 */
public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
        if (chars.isEmpty()) {
            return 0;
        }
        int[] mapping = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 'a';
            mapping[index]++;
        }
        int counter = 0;
        for (String word : words) {
            int[] dup = Arrays.copyOf(mapping, 26);
            if (isValid(word, chars, dup)) {
                counter += word.length();
            }
        }
        return counter;
    }

    boolean isValid(String word, String chars, int[] dup) {
        if (chars.length() < word.length())
            return false;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (dup[index] <= 0) {
                return false;
            }
            dup[index]--;
        }
        return true;
    }

    public static void main(String[] args) {
        CountCharacters countCharacters = new CountCharacters();
        System.out.println(countCharacters.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

}
