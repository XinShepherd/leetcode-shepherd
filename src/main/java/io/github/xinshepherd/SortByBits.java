package io.github.xinshepherd;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 * @author Fuxin
 * @since 2020/11/6
 */
public class SortByBits {

    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        int[] bits = new int[len];
        for (int i = 0; i < len; i++) {
            bits[i] = Integer.bitCount(arr[i]) * 1000000 + arr[i];
        }
        Arrays.sort(bits);
        for (int i = 0; i < len; i++) {
            bits[i] = bits[i] % 1000000;
        }
        return bits;
    }

    public int[] sortByBits2(int[] arr) {
        int len = arr.length;
        Node[] nodes = new Node[len];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            Node node = new Node();
            node.val = val;
            int count = 0;
            while (val > 0) {
                count++;
                val &= (val - 1);
            }
            node.bits = count;
            nodes[i] = node;
        }
        Arrays.sort(nodes, Comparator.comparingInt((Node n) -> n.bits)
                .thenComparingInt(n -> n.val));
        for (int i = 0; i < len; i++) {
            arr[i] = nodes[i].val;
        }
        return arr;
    }

    class Node {
        int val;
        int bits;
    }

    public static void main(String[] args) {
        SortByBits sortByBits = new SortByBits();
        assertThat(sortByBits.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})).isEqualTo(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7});
        assertThat(sortByBits.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})).isEqualTo(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024});
        assertThat(sortByBits.sortByBits(new int[]{10000, 10000})).isEqualTo(new int[]{10000, 10000});
        assertThat(sortByBits.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})).isEqualTo(new int[]{2, 3, 5, 17, 7, 11, 13, 19});
        assertThat(sortByBits.sortByBits(new int[]{10, 100, 1000, 10000})).isEqualTo(new int[]{10, 100, 10000, 1000});
        assertThat(sortByBits.sortByBits2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})).isEqualTo(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7});
        assertThat(sortByBits.sortByBits2(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})).isEqualTo(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024});
        assertThat(sortByBits.sortByBits2(new int[]{10000, 10000})).isEqualTo(new int[]{10000, 10000});
        assertThat(sortByBits.sortByBits2(new int[]{2, 3, 5, 7, 11, 13, 17, 19})).isEqualTo(new int[]{2, 3, 5, 17, 7, 11, 13, 19});
        assertThat(sortByBits.sortByBits2(new int[]{10, 100, 1000, 10000})).isEqualTo(new int[]{10, 100, 10000, 1000});
    }

}
