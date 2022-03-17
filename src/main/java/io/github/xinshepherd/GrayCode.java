package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 89. 格雷编码
 *
 * @author Fuxin
 * @since 2020/3/17 16:45
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0 ; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        GrayCode grayCode = new GrayCode();
        Assertions.assertThat(grayCode.grayCode(0)).isEqualTo(Arrays.asList(0));
        Assertions.assertThat(grayCode.grayCode(1)).isEqualTo(Arrays.asList(0, 1));
        Assertions.assertThat(grayCode.grayCode(2)).isEqualTo(Arrays.asList(0, 1, 3, 2));
        Assertions.assertThat(grayCode.grayCode(3)).isEqualTo(Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4));
        Assertions.assertThat(grayCode.grayCode(4)).isEqualTo(Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8));
    }

}
