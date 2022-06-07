package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 一个整数n和一个数组A，数组A只会包含0-9数组，求由A里面组成的整数小于n的最大的数
 * 比如n=23313, A=2，4，9。则结果为22999
 *
 * @author Fuxin
 */
public class ByteDanceI {

    public int getMaxNumber(int n, int[] A) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(A);
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Helper helper = new Helper(list, A);
        List<Integer> result = helper.getResult();

        if (result.isEmpty())
            return -1;
        int ans = 0;
        for (Integer num : result) {
            ans = ans * 10 + num;
        }
        return ans;
    }

    int findMaxLessNum(int[] A, int num) {
        int r = -1;
        for (int a : A) {
            if (a >= num) {
                break;
            }
            r = a;
        }
        return r;
    }

    class Helper {
        final List<Integer> numberList;
        final int[] A;
        Set<Integer> numberSet;
        boolean equal = true;
        boolean findLess = false;
        List<Integer> result = new ArrayList<>();

        public Helper(List<Integer> numberList, int[] A) {
            this.numberList = numberList;
            this.A = A;
            this.numberSet = new HashSet<>();
            for (int a : A) {
                numberSet.add(a);
            }
        }

        List<Integer> getResult() {
            int len = numberList.size();
            for (int i = len - 1; i >= 0 && i < len; ) {
                int num = numberList.get(i);
                if (i == 0) {
                    findLess = true;
                }
                if (equal) { // 确定前面的位数字是否相等
                    if (findLess) {
                        i = findLessNum(i, num);
                    } else if (numberSet.contains(num)) {
                        result.add(num);
                        i--;
                    } else {
                        i = findLessNum(i, num);
                    }
                } else {
                    result.add(A[A.length - 1]);
                    i--;
                }
            }
            return result;
        }

        int findLessNum(int i, int num) {
            int maxLessNum = findMaxLessNum(A, num);
            if (maxLessNum == -1) { // 没找到，需要回溯
                if (result.isEmpty()) { // 如果首位为空表示
                    if (numberList.size() == 1) {
                        return -1; // 跳出循环
                    } else {
                        result.add(0);
                        equal = false;
                        return --i;
                    }
                } else {
                    result.remove(result.size() - 1);
                    findLess = true;
                    return ++i;
                }
            } else {
                result.add(maxLessNum);
                equal = false;
                return --i;
            }
        }
    }

    public static void main(String[] args) {
        ByteDanceI byteDanceI = new ByteDanceI();
        Assertions.assertThat(byteDanceI.getMaxNumber(22313, new int[]{2, 4, 9})).isEqualTo(22299);
        Assertions.assertThat(byteDanceI.getMaxNumber(23313, new int[]{2, 4, 9})).isEqualTo(22999);
        Assertions.assertThat(byteDanceI.getMaxNumber(11111, new int[]{2, 4, 9})).isEqualTo(9999);
        Assertions.assertThat(byteDanceI.getMaxNumber(1, new int[]{2, 4, 9})).isEqualTo(-1);
        Assertions.assertThat(byteDanceI.getMaxNumber(2, new int[]{2})).isEqualTo(-1);
    }

}
