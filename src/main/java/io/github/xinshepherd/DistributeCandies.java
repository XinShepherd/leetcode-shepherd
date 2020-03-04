package io.github.xinshepherd;

public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        if (num_people == 0 || candies == 0)
            return ans;
        int step = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies > step) {
                    ans[i] += step;
                    candies -= step;
                } else {
                    ans[i] += candies;
                    candies -= candies;
                }
                step++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        int[] ans = distributeCandies.distributeCandies(7, 4);
        print(ans);
        print(distributeCandies.distributeCandies(10, 3));
        print(distributeCandies.distributeCandies(10, 0));
        print(distributeCandies.distributeCandies(0, 10));
        print(distributeCandies.distributeCandies(1, 10));
    }

    static void print(int[] ans) {
        for (int a : ans) {
            System.out.print(a + ",");
        }
        System.out.println();
    }

}
