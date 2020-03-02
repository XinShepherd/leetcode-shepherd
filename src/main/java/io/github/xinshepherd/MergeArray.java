package io.github.xinshepherd;

/**
 * 88. 合并两个有序数组
 *
 * @author Fuxin
 * @since 2020/2/27 16:20
 */
public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0)
            return;
        int i = 0, j = 0;
        int lastIndex = m - 1;
        // 插入排序
        while (i <= lastIndex && j < n) {
            int k = j;
            while (j < n &&nums2[j] < nums1[i]) {
                j++;
            }
            int len = j - k;
            if (len > 0) {
//                lastIndex += len;
//                for (int l = lastIndex + len; l >= i + len; l--) {
//                    nums1[l] = nums1[l - len];
//                }
                System.arraycopy(nums1, i, nums1, i + len, lastIndex - i + 1);
                lastIndex += len;
                for (int l = i; l < i + len; l++) {
                    nums1[l] = nums2[k++];
                }
                i += len;
            } else {
                i++;
            }
        }
        while (j < n) {
            nums1[++lastIndex] = nums2[j++];
        }
    }

    // 双指针从后往前比较
    public void mergeBack(int[] A, int m, int[] B, int n) {
        int i = n - 1, j = m - 1;
        int last = n + m - 1;
        while(i >= 0 && j >= 0){
            if(B[i] >= A[j]){
                A[last--] = B[i--];
            } else {
                A[last--] = A[j--];
            }
        }
        while(i >= 0){
            A[last--] = B[i--];
        }
    }

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int[] num1 = {1, 2, 7, 0, 0, 0};
        mergeArray.merge(num1, 3, new int[]{2, 5, 6}, 3);
        print(num1);
    }

    static void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ",");
        }
        System.out.println();
    }

}
