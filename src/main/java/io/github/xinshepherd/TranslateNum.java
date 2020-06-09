package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 面试题46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author Fuxin
 * @since 2020/6/9
 */
public class TranslateNum {

    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < numStr.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0)
                continue;
            String sub = numStr.substring(i - 1, i + 1);
            if (sub.compareTo("25") <= 0 && sub.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        assertThat(translateNum.translateNum(12258)).isEqualTo(5);
    }
}
