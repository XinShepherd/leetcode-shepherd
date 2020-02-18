package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestSubStr(String str) {
        int length = str.length();
        if (length == 0) return 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        for (; end < length ;) {

            char c = str.charAt(end);
            if (map.containsKey(c)) {
                Integer index = map.get(c);
                max = Math.max(max, end - index);
            }
            map.put(c, end);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubStr("abcabcbb"));
        System.out.println(solution.longestSubStr("bbbbb"));
        System.out.println(solution.longestSubStr("pwwkew"));
    }
}
