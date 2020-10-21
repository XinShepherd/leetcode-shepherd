package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 925. 长按键入
 *
 * https://leetcode-cn.com/problems/long-pressed-name/
 *
 * @author Fuxin
 * @since 2020/10/21
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int nLen = name.length();
        int tLen = typed.length();
        int i = 0, j = 0;
        while (i < nLen && j < tLen) {
            char nc = name.charAt(i);
            int count = 1;
            i++;
            while (i < nLen && name.charAt(i) == nc) {
                count++;
                i++;
            }
            while (j < tLen && typed.charAt(j) == nc) {
                count--;
                j++;
            }
            if (count > 0)
                return false;
        }
        return i == nLen && j == tLen;
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        assertThat(longPressedName.isLongPressedName("alex", "aaleex")).isTrue();
        assertThat(longPressedName.isLongPressedName("saeed", "ssaaedd")).isFalse();
        assertThat(longPressedName.isLongPressedName("leelee", "lleeelee")).isTrue();
        assertThat(longPressedName.isLongPressedName("laiden", "laiden")).isTrue();
    }

}
