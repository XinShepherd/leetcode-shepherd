package io.github.xinshepherd;

public class ThreadTests {

    private static final Object lock = new Object();

    static class A extends Thread {
        @Override
        public void run() {
            try {
                lock.wait();
                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            lock.notify();
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (Exception e) {
            //
        }

    }
}
