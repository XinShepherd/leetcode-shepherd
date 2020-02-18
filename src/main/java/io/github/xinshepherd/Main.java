package io.github.xinshepherd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int[] ints = getIntArray(line);
        int sum = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int num : ints) {
            int result = sum - num;
            if (set.contains(result)) {
                if (num > result) {
                    System.out.println(result + " " + num);
                } else {
                    System.out.println(num + " " + result);
                }
            } else {
                set.add(num);
            }
        }
    }

    static int[] getIntArray(String line) {
        String[] split = line.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        return ints;
    }
}
