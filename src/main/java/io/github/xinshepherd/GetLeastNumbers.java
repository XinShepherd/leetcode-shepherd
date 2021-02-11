package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author Fuxin
 * @since 2021/1/30
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }
        partitionArray(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void partitionArray(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        if (partition == k) {
            return;
        } else if (partition < k) {
            partitionArray(arr, partition + 1, right, k);
        } else {
            partitionArray(arr, left, partition - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int start = left;
        int pivot = arr[start];
        left++;
        while (left <= right) {
            // 左边是小于等于 pivot 的元素
            while (left <= right && arr[left] <= pivot)
                left++;
            // 右边是大于 pivot 的元素
            while (left <= right && arr[right] > pivot)
                right--;
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // left 和 right 交叉之后，right 指向小于 pivot 的地方
        // 所以 start 和 right 能正确交换，right 索引就是中轴
        swap(arr, start, right);
        return right;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        SolutionII solutionII = new SolutionII();
        return solutionII.getLeastNumbers(arr, k);
    }

    // 最大堆
    static class SolutionII {

        private int[] elements;
        private int size;

        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length <= k)
                return arr;
            if (k <= 0) {
                return new int[]{};
            }
            elements = new int[k];
            size = 0;
            for (int num : arr) {
                add(num);
            }
            return elements;
        }

        private void add(int num) {
            int i = size;
            if (i < elements.length) {
                size++;
                siftUp(i, num);
            } else if (elements[0] > num) {
                siftDown(0, num);
            }
        }

        private void siftUp(int k, int num) {
            while (k > 0) {
                int parent = (k - 1) >> 1;
                int e = elements[parent];
                if (e >= num)
                    break;
                elements[k] = e;
                k = parent;
            }
            elements[k] = num;
        }

        private void siftDown(int k, int num) {
            int half = size >>> 1;
            while (k < half) {
                int child = (k << 1) + 1;
                int right = child + 1;
                if (right < size) {
                    child = elements[child] > elements[right] ? child : right;
                }
                int e = elements[child];
                if (num >= e) {
                    break;
                }
                elements[k] = e;
                k = child;
            }
            elements[k] = num;
        }

    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        assertThat(getLeastNumbers.getLeastNumbers(new int[]{3, 2, 1}, 2)).isEqualTo(new int[]{1, 2});
        assertThat(getLeastNumbers.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)).isEqualTo(new int[]{0});
        assertThat(getLeastNumbers.getLeastNumbers2(new int[]{3, 2, 1}, 2)).containsExactlyInAnyOrder(1, 2);
        assertThat(getLeastNumbers.getLeastNumbers2(new int[]{0, 1, 2, 1}, 1)).isEqualTo(new int[]{0});
        assertThat(getLeastNumbers.getLeastNumbers2(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8)).containsExactlyInAnyOrder(0, 0, 1, 1, 2, 2, 2, 3);
    }

}
