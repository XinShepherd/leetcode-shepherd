package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 126. 单词接龙 II
 * https://leetcode-cn.com/problems/word-ladder-ii/
 *
 * @author Fuxin
 * @since 2020/6/7
 */
public class FindLadders {

    int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }
        boolean[] dp = new boolean[wordList.size()];
        List<List<String>> ans = new ArrayList<>();
        Deque<String> result = new LinkedList<>();
        result.addLast(beginWord);
        find(beginWord, endWord, wordList, dp, ans, result);
        return ans;
    }

    void find(String beginWord, String endWord, List<String> wordList, boolean[] dp, List<List<String>> ans, Deque<String> result) {
        if (canTransform(beginWord, endWord)) {
            ArrayList<String> list = new ArrayList<>(result);
            list.add(endWord);
            if (list.size() < min) {
                ans.clear();
                ans.add(list);
                min = list.size();
            } else if (list.size() == min) {
                ans.add(list);
            }
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (result.size() >= min) {
                return;
            }
            if (!dp[i]) {
                String word = wordList.get(i);
                boolean canTransform = canTransform(beginWord, word);
                if (canTransform) {
                    result.addLast(word);
                    dp[i] = true;
                    find(word, endWord, wordList, dp, ans, result);
                    dp[i] = false;
                    result.removeLast();
                }
            }
        }
    }

    boolean canTransform(String beginWord, String word) {
        char[] wordArr = word.toCharArray();
        char[] beginArr = beginWord.toCharArray();
        int count = 0;
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] != beginArr[i]) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return count == 1;
    }

    // leetcode
    // 官方

    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId = new HashMap<>(); // 单词到id的映射
    private ArrayList<String> idWord = new ArrayList<>(); // id到单词的映射
    private ArrayList<Integer>[] edges; // 图的边

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        // 若endWord不在wordList中 则无解
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // 把beginWord也加入wordId中
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        // 初始化存边用的数组
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                // 若两者可以通过转换得到 则在它们间建一条无向边
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord); // 目的ID
        List<List<String>> res = new ArrayList<>(); // 存答案
        int[] cost = new int[id]; // 到每个点的代价
        for (int i = 0; i < id; i++) {
            cost[i] = INF; // 每个点的代价初始化为无穷大
        }

        // 将起点加入队列 并将其cost设为0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // 开始广度优先搜索
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1); // 最近访问的点
            if (last == dest) { // 若该点为终点则将其存入答案res中
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index)); // 转换为对应的word
                }
                res.add(tmp);
            } else { // 该点不为终点 继续搜索
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    // 此处<=目的在于把代价相同的不同路径全部保留下来
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // 把to加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp); // 把这个路径加入队列
                    }
                }
            }
        }
        return res;
    }

    // 两个字符串是否可以通过改变一个字母后相等
    boolean transformCheck(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length() && differences < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }


    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        assertThat(findLadders.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")))
                .isEqualTo(Arrays.asList(Arrays.asList("hit", "hot", "dot", "dog", "cog"), Arrays.asList("hit", "hot", "lot", "log", "cog")));
    }

}
