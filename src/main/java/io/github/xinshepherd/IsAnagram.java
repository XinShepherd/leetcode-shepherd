package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 242. 有效的字母异位词
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        int[] tNums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            tNums[index]++;
            if (tNums[index] > nums[index])
                return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tNums[i])
                return false;
        }
        return true;
    }

    // 极速
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < ss.length; ++i) {
            cnt[ss[i] - 'a']++;
            cnt[tt[i] - 'a']--;
        }
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        Assertions.assertThat(isAnagram.isAnagram("anagram", "nagaram")).isTrue();
        Assertions.assertThat(isAnagram.isAnagram("rat", "cat")).isFalse();
        Assertions.assertThat(isAnagram.isAnagram("aaa", "aa")).isFalse();
        Assertions.assertThat(isAnagram.isAnagram2("anagram", "nagaram")).isTrue();
        Assertions.assertThat(isAnagram.isAnagram2("rat", "cat")).isFalse();
        Assertions.assertThat(isAnagram.isAnagram2("aaa", "aa")).isFalse();
        Assertions.assertThat(isAnagram.isAnagram2("bb", "aa")).isFalse();
    }

}
