package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 331. 验证二叉树的前序序列化
 *
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * @author Fuxin
 * @since 2021/3/12
 */
public class ValidSerialization {

    public boolean isValidSerialization(String preorder) {
        if ("#".equals(preorder))
            return true;
        String[] strings = preorder.split(",");
        int len = strings.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if ("#".equals(strings[i])) {
                if (stack.isEmpty())
                    return false;
                Integer poll = stack.poll() - 1;
                while (poll == 0 && !stack.isEmpty()) {
                    poll = stack.poll() - 1;
                }
                if (poll == 0) {
                    return i >= len - 1;
                }
                stack.push(poll);
            } else {
                stack.push(2);
            }
        }
        return false;
    }
    public boolean isValidSerialization2(String preorder) {
        int count = 0;
        char[] chars = preorder.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '#') {
                count--;
                if (count == -1) {
                    return i == len - 1;
                }
            } else if (c == ',') {
                if (chars[i - 1] != '#') {
                    count++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidSerialization validSerialization = new ValidSerialization();
        assertThat(validSerialization.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")).isTrue();
        assertThat(validSerialization.isValidSerialization("1,#")).isFalse();
        assertThat(validSerialization.isValidSerialization("9,#,#,1")).isFalse();
        assertThat(validSerialization.isValidSerialization("#")).isTrue();
        assertThat(validSerialization.isValidSerialization("#, #")).isFalse();
        assertThat(validSerialization.isValidSerialization2("9,3,4,#,#,1,#,#,2,#,6,#,#")).isTrue();
        assertThat(validSerialization.isValidSerialization2("1,#")).isFalse();
        assertThat(validSerialization.isValidSerialization2("9,#,#,1")).isFalse();
        assertThat(validSerialization.isValidSerialization2("#")).isTrue();
        assertThat(validSerialization.isValidSerialization2("#, #")).isFalse();
    }

}
