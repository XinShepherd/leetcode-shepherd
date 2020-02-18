package io.github.xinshepherd;

import java.util.Scanner;

public class BinaryBitNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        long count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }

        System.out.println(count);
    }
}
