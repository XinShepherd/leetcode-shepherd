package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int i = 0, j = i + 1;
        for (; j < length; j++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            if (j - i > 1) {
                nums[++i] = nums[j];
            } else {
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        Assertions.assertThat(removeDuplicates.removeDuplicates(new int[]{1})).isEqualTo(1);
        Assertions.assertThat(removeDuplicates.removeDuplicates(new int[]{1, 2})).isEqualTo(2);
        Assertions.assertThat(removeDuplicates.removeDuplicates(new int[]{1, 2, 3})).isEqualTo(3);
        Assertions.assertThat(removeDuplicates.removeDuplicates(new int[]{1, 1, 2})).isEqualTo(2);
        Assertions.assertThat(removeDuplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})).isEqualTo(5);
    }

}
