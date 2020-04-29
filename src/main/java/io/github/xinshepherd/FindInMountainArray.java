package io.github.xinshepherd;

/**
 * 1095. 山脉数组中查找目标值
 *
 * @author Fuxin
 * @since 2020/4/29
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int index = findIndex(mountainArr);
        int i = binarySearch(0, index, false, mountainArr, target);
        if (i != -1) {
            return i;
        }
        return binarySearch(index, mountainArr.length(), true, mountainArr, target);
    }

    int binarySearch(int left, int right, boolean reverse, MountainArray mountainArray, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            int v = mountainArray.get(mid);
            if (target > v) {
                if (reverse)
                    right = mid;
                else
                    left = mid + 1;
            } else if (target < v){
                if (reverse)
                    left = mid + 1;
                else
                    right = mid;
            } else
                return mid;
        }
        return -1;
    }

    int findIndex(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length();

        while (left < right) {
            int mid = (right + left) / 2;
            int v = mountainArr.get(mid);
            if (mid - 1 >= left) {
                int before = mountainArr.get(mid - 1);
                if (before > v) {
                    right = mid;
                    continue;
                }
            }
            if (mid + 1 <= right) {
                int after = mountainArr.get(mid + 1);
                if (after > v) {
                    left = mid;
                    continue;
                }
            }
            return mid;
        }
        return left;
    }

    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     *
     */
    interface MountainArray {
        int get(int index);
        int length();
    }

    static class MountainArrayImpl implements MountainArray {
        int[] array;

        public MountainArrayImpl(int[] array) {
            this.array = array;
        }

        @Override
        public int get(int index) {
            return array[index];
        }

        @Override
        public int length() {
            return array.length;
        }
    }



    public static void main(String[] args) {
        FindInMountainArray mountainArray = new FindInMountainArray();
        MountainArray array = new MountainArrayImpl(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println("peek: " + mountainArray.findIndex(array) + " index: " + mountainArray.findInMountainArray(4, array));
        System.out.println("peek: " + mountainArray.findIndex(array) + " index: " + mountainArray.findInMountainArray(2, array));
        System.out.println("peek: " + mountainArray.findIndex(array) + " index: " + mountainArray.findInMountainArray(1, array));
        array = new MountainArrayImpl(new int[]{0, 1, 2, 4, 2, 1});
        System.out.println("peek: " + mountainArray.findIndex(array) + " index: " + mountainArray.findInMountainArray(1, array));
        System.out.println("peek: " + mountainArray.findIndex(array) + " index: " + mountainArray.findInMountainArray(3, array));
    }


}
