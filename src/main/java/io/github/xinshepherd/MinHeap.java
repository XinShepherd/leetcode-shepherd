package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 最小堆
 *
 * @author Fuxin
 * @since 2021/2/11
 */
public class MinHeap {

    private int[] array;
    private int size;

    public MinHeap() {
        this.array = new int[16];
    }

    public boolean offer(int num) {
        int i = size;
        if (i >= array.length) {
            grow();
        }
        size++;
        siftUp(i, num);
        return true;
    }

    private void siftUp(int i, int num) {
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            int e = array[parent];
            if (e <= num)
                break;
            array[i] = e;
            i = parent;
        }
        array[i] = num;
    }

    private void grow() {
        if (array.length > (Integer.MAX_VALUE >> 1))
            throw new RuntimeException();
        array = Arrays.copyOf(array, array.length << 1);
    }

    public int poll() {
        if (size <= 0)
            throw new RuntimeException();
        int e = array[0];
        int num = array[--size];
        array[0] = num;
        siftDown(0, num);
        return e;
    }

    private void siftDown(int k, int num) {
        int half = size >>> 1;
        while (k < half) {
            int child = k << 1 + 1;
            int right = child + 1;
            if (right < size) {
                child = array[child] <= array[right] ? child : right;
            }
            int e = array[child];
            if (num <= e) {
                break;
            }
            array[k] = e;
            k = child;
        }
        array[k] = num;
    }

    public int peek() {
        if (size <=0)
            throw new RuntimeException();
        return array[0];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.offer(4);
        minHeap.offer(2);
        minHeap.offer(5);
        assertThat(minHeap.peek()).isEqualTo(2);
        minHeap.offer(1);
        assertThat(minHeap.peek()).isEqualTo(1);
        minHeap.offer(7);
        assertThat(minHeap.peek()).isEqualTo(1);
        assertThat(minHeap.poll()).isEqualTo(1);
        assertThat(minHeap.peek()).isEqualTo(2);
    }
}
