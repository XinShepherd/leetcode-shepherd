package io.github.xinshepherd;

import java.util.AbstractMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author Fuxin
 * @since 2020/5/28
 */
public class DecodeString {

    public String decodeString(String s) {
        AbstractMap.SimpleEntry<String, Integer> decode = decode(s.toCharArray(), 0);
        return decode.getKey();
    }

    private AbstractMap.SimpleEntry<String, Integer> decode(char[] chars, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < chars.length; j++) {
            if (chars[j] == '[') {
                AbstractMap.SimpleEntry<String, Integer> decode = decode(chars, j + 1);
                sb.append(decode.getKey());
                j = decode.getValue();
            } else if (chars[j] == ']') {
                int k = i - 2;
                StringBuilder numbers = new StringBuilder();
                for (; k >= 0; k--) {
                    if (chars[k] - '0' <= 9) {
                        numbers.append(chars[k]);
                    } else {
                        break;
                    }
                }
                int value = Integer.parseInt(numbers.reverse().toString());
                StringBuilder builder = new StringBuilder();
                String repeatable = sb.toString();
                for (int l = 0; l < value; l++) {
                    builder.append(repeatable);
                }
                return new AbstractMap.SimpleEntry<>(builder.toString(), j);
            } else if (chars[j] - '0' > 9) {
                sb.append(chars[j]);
            }
        }
        return new AbstractMap.SimpleEntry<>(sb.toString(), chars.length);
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        assertThat(decodeString.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
        assertThat(decodeString.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
        assertThat(decodeString.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
    }

}
