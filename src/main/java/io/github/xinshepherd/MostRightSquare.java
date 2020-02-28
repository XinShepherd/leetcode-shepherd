package io.github.xinshepherd;

// 求一个数的平方最右是否等于该数，如25的平方625最右边25是该数。
public class MostRightSquare {

    public boolean mostRightSquare(long n) {
        long square = n * n;
        long divisor = 1;
        long temp = n;
        while (temp > 0) {
            divisor *= 10;
            temp /= 10;
        }
        return (square - n) % divisor == 0;
    }

    public static void main(String[] args) {
        MostRightSquare mostRightSquare = new MostRightSquare();
        System.out.println("1: " + mostRightSquare.mostRightSquare(1));
        System.out.println("5: " + mostRightSquare.mostRightSquare(5));
        System.out.println("6: " + mostRightSquare.mostRightSquare(6));
        System.out.println("25: " + mostRightSquare.mostRightSquare(25));
        System.out.println("40: " + mostRightSquare.mostRightSquare(40));
        System.out.println("30: " + mostRightSquare.mostRightSquare(30));
        System.out.println("36: " + mostRightSquare.mostRightSquare(36));
        System.out.println("125: " + mostRightSquare.mostRightSquare(125));
    }

}
