package io.github.xinshepherd;

/**
 * 50. Pow(x, n)
 *
 * @author Fuxin
 * @since 2020/3/24 11:14
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(0, 0));
        System.out.println(myPow.myPow(1, 0));
        System.out.println(myPow.myPow(-1, 0));
        System.out.println(myPow.myPow(2, 2));
        System.out.println(myPow.myPow(2, 10));
        System.out.println(myPow.myPow(-2, 10));
        System.out.println(myPow.myPow(2, -2));
        System.out.println(myPow.myPow(-2, -3));
    }
}
