package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author Fuxin
 * @since 2020/6/12
 */
public class ConvertZ {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ConvertZ convertZ = new ConvertZ();
        assertThat(convertZ.convert("LEETCODEISHIRING", 3)).isEqualTo("LCIRETOESIIGEDHN");
        assertThat(convertZ.convert("LEETCODEISHIRING", 4)).isEqualTo("LDREOEIIECIHNTSG");
    }

}
