package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

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
        Assertions.assertThat( mostRightSquare.mostRightSquare(1)).isEqualTo(true);
        Assertions.assertThat( mostRightSquare.mostRightSquare(5)).isEqualTo(true);
        Assertions.assertThat( mostRightSquare.mostRightSquare(6)).isEqualTo(true);
        Assertions.assertThat( mostRightSquare.mostRightSquare(25)).isEqualTo(true);
        Assertions.assertThat( mostRightSquare.mostRightSquare(40)).isEqualTo(false);
        Assertions.assertThat( mostRightSquare.mostRightSquare(30)).isEqualTo(false);
        Assertions.assertThat( mostRightSquare.mostRightSquare(36)).isEqualTo(false);
        Assertions.assertThat( mostRightSquare.mostRightSquare(125)).isEqualTo(false);
    }

}
