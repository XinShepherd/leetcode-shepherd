package io.github.xinshepherd;

import java.util.ArrayList;
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
        System.out.println(grayCode.grayCode(0));
        System.out.println(grayCode.grayCode(1));
        System.out.println(grayCode.grayCode(2));
        System.out.println(grayCode.grayCode(3));
        System.out.println(grayCode.grayCode(4));
    }

}
