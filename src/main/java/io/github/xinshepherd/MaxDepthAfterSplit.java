package io.github.xinshepherd;

/**
 * 1111. 有效括号的嵌套深度
 * <p>
 * 需要细品
 *
 * @author Fuxin
 * @since 2020/4/1
 */
public class MaxDepthAfterSplit {

    public int[] maxDepthAfterSplit(String seq) {
        if (seq.length() == 0)
            return new int[0];
        int[] ans = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                ans[i] = depth % 2;
            } else {
                ans[i] = depth % 2;
                depth--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxDepthAfterSplit split = new MaxDepthAfterSplit();
        Util.printArray(split.maxDepthAfterSplit("(()())"));
        Util.printArray(split.maxDepthAfterSplit("()(())()"));
    }

}
