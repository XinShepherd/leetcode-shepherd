package io.github.xinshepherd;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author Fuxin
 * @since 2020/3/17 16:21
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return Collections.emptyList();
        List<List<String>> results = new LinkedList<>();
        Map<String, List<String>> mapping = new HashMap<>();
        for (String str : strs) {
            int[] ascii = new int[26];
            for (int i = 0; i < str.length(); i++) {
                ascii[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ascii.length; i++) {
                if (ascii[i] != 0) {
                    char c = (char) ('a' + i);
                    sb.append(c).append(ascii[i]);
                }
            }
            String key = sb.toString();
            List<String> list = mapping.computeIfAbsent(key, k -> {
                LinkedList<String> result = new LinkedList<>();
                results.add(result);
                return result;
            });
            list.add(str);
        }
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }


}
