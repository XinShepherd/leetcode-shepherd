package io.github.xinshepherd;

// 300. 最长上升子序列
public class LengthOfLIS {

    int max = 0;

    public int lengthOfLIS(int[] nums) {
//        max = 0;
//        backtrack(nums, 0, Integer.MIN_VALUE, 0);
//        return max;
        return binarySearch(nums);
    }

    int dp(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int maxans = 0;
        maxans = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(dp[j], maxval);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    // 贪心 + 二分查找
    int binarySearch(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] d = new int[nums.length + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (nums[i] > d[mid]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    // 指数型
    void backtrack(int[] nums, int index, int before, int count) {
        if (index == nums.length) {
            if (count > max) {
                max = count;
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > before) {
                backtrack(nums, i + 1, nums[i], count + 1);
            }
        }
        if (count > max) {
            max = count;
        }
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{7, 8, 2, 3, 4, 6, 9, 7, 8}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
