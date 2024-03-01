package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) return 0;
        int i = 0, j = length - 1;
        while (j > i) {
            for (; j > i; j--) {
                if (nums[j] != val) {
                    break;
                }
            }
            for (; i < j; i++) {
                if (nums[i] == val)
                    break;
            }
            if (j != i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (j == 0 && nums[j] == val) {
            return 0;
        }
        return j + 1;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] arrays = {3, 2, 2, 3};
        Assertions.assertThat(removeElement.removeElement(arrays, 3)).isEqualTo(2);
        arrays = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        Assertions.assertThat(removeElement.removeElement(arrays, 2)).isEqualTo(5);
    }
}
